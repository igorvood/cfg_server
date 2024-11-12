package ru.vood.configuration.server.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.configuration.server.repo.dto.DataBasePlaceHolder
import ru.vood.configuration.server.repo.dto.StandEnum
import ru.vood.configuration.server.abstraction.AbstractDatasourceTests
import kotlin.test.assertContains

internal class PlaceHolderRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var placeHolderRepositoryImpl: PlaceHolderRepositoryImpl

    @Test
    fun dbPlaceHolders() {
        val dbPlaceHolders = placeHolderRepositoryImpl.dbPlaceHolders()
        assertContains(dbPlaceHolders, DataBasePlaceHolder("PARALLELISM", "PARALLELISM", "2"))
    }

    @Test
    fun placeHolderByService() {

        val dbPlaceHolders = placeHolderRepositoryImpl.placeHolderByService(
            "uasp-streaming-mdm-enrichment",
            "profile-tx-step1",
            StandEnum.DSO,
            "DSO_KAFKA_SSL_KEYSTORE_PASSWORD"
        )
        assertContains("\${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}", dbPlaceHolders)


    }
}