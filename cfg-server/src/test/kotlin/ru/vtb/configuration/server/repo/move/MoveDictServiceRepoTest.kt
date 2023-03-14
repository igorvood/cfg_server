package ru.vtb.configuration.server.repo.move

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.PlaceHolderRepositoryImpl
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.test.util.assertTransaction

internal class MoveDictServiceRepoTest: AbstractDatasourceTests() {

    @Autowired
    lateinit var iMoveDictServiceRepo: IMoveDictServiceRepo


    @Test
    fun srvArrowsMove() {
        assertTransaction {
            iMoveDictServiceRepo.srvArrowsMove(              "1","2","3", "4")
        }

    }

    @Test
    fun abstractServiceMove() {
        assertTransaction {
            iMoveDictServiceRepo.abstractServiceMove(              "1","2","3", "4")
        }

    }

    @Test
    fun flinkPropValueMove() {
        assertTransaction {
        iMoveDictServiceRepo.flinkPropValueMove(              "1","2","3", "4")
    }
    }

    @Test
    fun serviceGroupMove() {
        assertTransaction {
            iMoveDictServiceRepo.serviceGroupMove(              "1","2","3", "4")
        }

    }

    @Test
    fun serviceNodeMove() {
        assertTransaction {
            iMoveDictServiceRepo.serviceNodeMove(              "1","2","3", "4")
        }
    }

    @Test
    fun placeHolderByServiceMove() {
        assertTransaction {
            iMoveDictServiceRepo.placeHolderByServiceMove(              "1","2","3", "4")
        }
    }

}