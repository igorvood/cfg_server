package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityRestEdit

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class Dictasdaasdasdasd {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicParamsByStandEntityGeneratedRepository

    protected val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule())

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Disabled
    fun editEntity() {

        val primaryKey: ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK =
            DictTopicParamsByStandEntityPK().apply {
                nodeId = "asd"
                standId = "asd"
            }
        val newData1: DictTopicParamsByStandEntityImmutable =
            DictTopicParamsByStandEntityImmutable("asd", "asd", 23, "d")


        val restEditEntityDto = DictTopicParamsByStandEntityRestEdit(primaryKey, newData1)

        val newData = restEditEntityDto.newData

        val writeValueAsString = mapper.writeValueAsString(restEditEntityDto)

        val andDo = mockMvc.perform(
            MockMvcRequestBuilders.put("/AAAAAAA/editEntity11")
                .content(writeValueAsString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andDo(MockMvcResultHandlers.print())

        andDo
            .andExpect(MockMvcResultMatchers.status().isOk)

    }
}