package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.vtb.processor.intf.IImmutableEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import ru.vtb.processor.wrapper.RestEditEntityDto
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//@SpringBootTest
@AutoConfigureMockMvc
abstract class AbstractEntityGeneratedRestApiRESTController<
        HIBER_ENTITY : Any,
        HIBER_ENTITY_Immutable : IImmutableEntity<HIBER_ENTITY>,
        PK:Any,
        Repository : JpaRepository<HIBER_ENTITY, PK>,
        EDIT: IRestEditEntityDto<PK, HIBER_ENTITY_Immutable>
        > {


    abstract val hibernateEntityImmutable: HIBER_ENTITY_Immutable

    abstract val pk: PK

    fun wrappedPk(): PrimaryKeyWrapper<PK> = PrimaryKeyWrapper(pk)

    abstract fun getMockedRepo(): Repository

    fun getHibernateEntity(): HIBER_ENTITY = hibernateEntityImmutable.toMutable()

//    val restEditEntityDto = object : IRestEditEntityDto<PK, HIBER_ENTITY_Immutable> {
//        override val primaryKey: PK
//            get() = pk
//        override val newData: HIBER_ENTITY_Immutable
//            get() = hibernateEntityImmutable
//    }

    abstract fun restEditEntityDto (): EDIT

    protected val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    protected fun hibernateEntitySimpleName(): String = getHibernateEntity()::class.java.simpleName

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun findAll() {
        mockMvc.perform(MockMvcRequestBuilders.get("/${hibernateEntitySimpleName()}/findAll"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
    }

    @Test
    fun findById() {
        mockMvc.perform(
            MockMvcRequestBuilders.put("/${hibernateEntitySimpleName()}/findById")
                .content(mapper.writeValueAsString(wrappedPk()))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun save() {

        val entity = hibernateEntityImmutable.toMutable()
        val mockedRepo = getMockedRepo()
        every { mockedRepo.save(entity) } returns entity


        val writeValueAsString = mapper.writeValueAsString(hibernateEntityImmutable)

        val andDo = mockMvc.perform(
            MockMvcRequestBuilders.put("/${hibernateEntitySimpleName()}/save")
                .content(writeValueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())
        val andExpect = andDo
            .andExpect(MockMvcResultMatchers.status().isOk)
        println(andExpect.andReturn().response.contentAsString)
        assertEquals(writeValueAsString, andExpect.andReturn().response.contentAsString)

    }

    @Test
    fun deleteById() {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/${hibernateEntitySimpleName()}/deleteById")
                .content(mapper.writeValueAsString(wrappedPk()))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun editEntity() {

//        val restEditEntityDto = RestEditEntityDto(wrappedPk(), hibernateEntityImmutable)

        val writeValueAsString = mapper.writeValueAsString(restEditEntityDto())

        val andDo = mockMvc.perform(
            MockMvcRequestBuilders.post("/${hibernateEntitySimpleName()}/editEntity")
                .content(writeValueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())

        andDo
            .andExpect(MockMvcResultMatchers.status().isOk)

    }

}