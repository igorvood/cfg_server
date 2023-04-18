package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.swagger.v3.oas.annotations.Operation
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import ru.vtb.processor.wrapper.RestEditEntityDto
import java.math.BigInteger
import kotlin.test.assertEquals

//@ExtendWith(SpringExtension::class)
//@WebMvcTest//(controllers = [DictTopicOwnerEntityGeneratedRestApi::class])
//@DataJpaTest
@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DictTopicOwnerEntityGeneratedRestApiRESTController {

    @MockkBean(relaxed = true)
//    lateinit var mvcs: JpaRepository<DictTopicOwnerEntity, String>
    lateinit var repository:  DictTopicOwnerEntityGeneratedRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    val mapper = ObjectMapper().registerModule(KotlinModule())

    @Test
    fun findAll() {
        mockMvc.perform(get("/DictTopicOwnerEntity/findAll"))
            .andDo(print())
            .andExpect(status().isOk)
            .andReturn()
    }

    @Test
    fun findById() {
        val primaryKeyWrapper = PrimaryKeyWrapper<String>("asdasd")


        mockMvc.perform(
            put("/DictTopicOwnerEntity/findById")
                .content(mapper.writeValueAsString(primaryKeyWrapper))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(status().isOk)
    }

    @Test
    fun save() {

        val dictTopicOwnerEntityImmutable = DictTopicOwnerEntityImmutable("asdasd", 1, "sd")

        val entity = dictTopicOwnerEntityImmutable.toMutable()
        every { repository.save(entity) } returns entity


        val writeValueAsString = mapper.writeValueAsString(dictTopicOwnerEntityImmutable)

        val andDo = mockMvc.perform(
            put("/DictTopicOwnerEntity/save")
                .content(writeValueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
        val andExpect = andDo
            .andExpect(status().isOk)
        println(andExpect.andReturn().response.contentAsString)
        assertEquals(writeValueAsString,  andExpect.andReturn().response.contentAsString)

    }

    @Test
    fun deleteById() {

        val primaryKeyWrapper = PrimaryKeyWrapper<String>("asdasd")


        mockMvc.perform(
            delete("/DictTopicOwnerEntity/deleteById")
                .content(mapper.writeValueAsString(primaryKeyWrapper))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(status().isOk)

    }

    @Test
    fun editEntity() {

        val primaryKeyWrapper = PrimaryKeyWrapper<String>("asdasd")

        val restEditEntityDto: RestEditEntityDto<String, DictTopicOwnerEntityImmutable> = RestEditEntityDto(primaryKeyWrapper, DictTopicOwnerEntityImmutable("asdasd", 1, "sd"))

        val writeValueAsString = mapper.writeValueAsString(restEditEntityDto)

        val canSerialize = mapper.canSerialize(RestEditEntityDto::class.java)

//        val readValue = mapper.readValue<RestEditEntityDto<String, DictTopicOwnerEntityImmutable>>(writeValueAsString, RestEditEntityDto::class.java)
           val readValue: RestEditEntityDto<*, *> = mapper.readValue(writeValueAsString, RestEditEntityDto::class.java)
        val restEditEntityDto1 = readValue as RestEditEntityDto<String, DictTopicOwnerEntityImmutable>


        val andDo = mockMvc.perform(
            post("/DictTopicOwnerEntity/editEntity")
                .content(writeValueAsString)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
        andDo
            .andExpect(status().isOk)

    }


//    @Operation(summary = "Удалить по идентификатору.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
//    @DeleteMapping("/deleteById", produces = [MediaType.APPLICATION_JSON_VALUE])
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    override fun deleteById(@RequestBody id: PrimaryKeyWrapper<String>) = DictTopicOwnerEntityGeneratedRepository.deleteById(id.primaryKey)
//
//    @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
//    @PostMapping("/editEntity", produces = [MediaType.APPLICATION_JSON_VALUE])
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    override fun editEntity(
//        @RequestBody editData: RestEditEntityDto<String, DictTopicOwnerEntityImmutable>,
//    ) = DictTopicOwnerEntityGeneratedRepository.findByIdOrNull(editData.primaryKeyWrapper.primaryKey)?.let { oldData ->


    }