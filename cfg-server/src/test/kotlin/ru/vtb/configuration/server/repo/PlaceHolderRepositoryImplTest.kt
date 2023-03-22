package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.dto.DataBasePlaceHolder
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import kotlin.test.assertContains

internal class PlaceHolderRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var placeHolderRepositoryImpl: PlaceHolderRepositoryImpl

    @Test
    fun dbPlaceHolders() {
        val dbPlaceHolders = placeHolderRepositoryImpl.dbPlaceHolders()
        assertContains(dbPlaceHolders, DataBasePlaceHolder("PARALLELISM", "PARALLELISM", "8"))
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