package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
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
        val s = """{"id":"asdasd","is_our": 1 ,"descriptionForReport":"sd"}"""

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

}