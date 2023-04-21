package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.jpa.repository.JpaRepository
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.processor.intf.IFilterHibernateEntity
import ru.vtb.processor.intf.OrIsNullRepository
import kotlin.test.assertContains
import kotlin.test.assertEquals

abstract class AbstractRepositoryTest<ENTITY, PK, FILTER_DTO : IFilterHibernateEntity> : AbstractDatasourceTests() {

    abstract val entityVal: ENTITY

    abstract val pk: PK

    abstract val filterDto: FILTER_DTO

    abstract fun repository(): JpaRepository<ENTITY, PK>

    abstract fun orIsNullRepository(): OrIsNullRepository<FILTER_DTO, ENTITY>

    @Test
    @DisplayName("Выполняются операции findById -> save -> findById -> deleteById")
    fun abstractFindById() {

        val findById = repository().findById(pk)

        assert(!findById.isPresent)
        val saved = withTransactional { repository().save(entityVal) }

        val findById1 = repository().findById(pk)

        assert(findById1.isPresent)
        assertEquals(saved, findById1.get())

        withTransactional { repository().deleteById(pk) }
    }

    @Test
    @DisplayName("Выполняются операции saveAll -> findByFilterOrIsNull -> deleteAllByIdInBatch")
    fun abstractSave() {
        val findById = withTransactional { repository().saveAll(listOf(entityVal)) }
        assertEquals(1, findById!!.size)
        assertEquals(entityVal, findById[0])

        val findByFilterOrIsNull = orIsNullRepository().findByFilterOrIsNull(filterDto)

        assertContains(findByFilterOrIsNull, findById[0])


        withTransactional { repository().deleteAllByIdInBatch(listOf(pk)) }
    }

}