package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
import ru.vtb.processor.intf.IImmutableEntity
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import ru.vtb.processor.wrapper.RestEditEntityDto
import kotlin.test.assertEquals

@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
abstract class AbstractEntityGeneratedRestApiRESTController<
        HIBER_ENTITY : Any,
        HIBER_ENTITY_Immutable: IImmutableEntity<HIBER_ENTITY>,
        PK,
        Repository: JpaRepository<HIBER_ENTITY, PK>
        > {


    abstract val hibernateEntityImmutable: HIBER_ENTITY_Immutable

    abstract val pk: PrimaryKeyWrapper<PK>

    abstract fun getMockedRepo():Repository


    fun getHibernateEntity(): HIBER_ENTITY = hibernateEntityImmutable.toMutable()

   protected val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    protected fun hibernateEntitySimpleName(): String = getHibernateEntity()::class.java.simpleName

//    IImmutableEntity<DictTopicOwnerEntity>

//    abstract var repository: REPO
//
//    @MockkBean(relaxed = true)
//    fun setRepository(repository: REPO)  {this.repository = repository}


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
                .content(mapper.writeValueAsString(pk))
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
        assertEquals(writeValueAsString,  andExpect.andReturn().response.contentAsString)

    }

    @Test
    fun deleteById() {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/${hibernateEntitySimpleName()}/deleteById")
                .content(mapper.writeValueAsString(pk))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun editEntity() {

        val restEditEntityDto = RestEditEntityDto(pk, hibernateEntityImmutable)

        val writeValueAsString = mapper.writeValueAsString(restEditEntityDto)

        val canSerialize = mapper.canSerialize(RestEditEntityDto::class.java)

//        val readValue = mapper.readValue<RestEditEntityDto<String, DictTopicOwnerEntityImmutable>>(writeValueAsString, RestEditEntityDto::class.java)
//        val readValue: RestEditEntityDto<*, *> = mapper.readValue(writeValueAsString, RestEditEntityDto::class.java)
//        val restEditEntityDto1 = readValue as RestEditEntityDto<String, DictTopicOwnerEntityImmutable>


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