package ru.vtb.configuration.server.check

import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcOperations
import ru.vtb.configuration.server.controller.intf.extractNamesPlaceholder
import ru.vtb.configuration.server.controller.placeholder.intf.HolderResolver

//@Service
class PlaceHolderChecker(
    val holderResolvers: List<HolderResolver>,
    private val jdbcTemplate: JdbcOperations
) : CheckService {

    private val logger = LoggerFactory.getLogger(PlaceHolderChecker::class.java)
    override fun check() {
        val classAndPlaceholders = holderResolvers.associate { it.javaClass to it.placeHolderName() }
        val revert = classAndPlaceholders
            .entries
            .flatMap { e -> e.value.map { e.key to it } }
            .groupBy { it.second }
            .map { it.key to it.value.map { cl -> cl.first }.toSet() }
            .filter { it.second.size > 1 }
            .map {
                "Place holder " + it.first + " resolve in several class " + it.second.map { cl -> cl.name }
                    .joinToString(", ")
            }

        require(revert.isEmpty()) { revert }


        val phFun = holderResolvers.flatMap { it.placeHolderName() }
        val factPh =
            jdbcTemplate.query("""select distinct PROP_VALUE from all_PLACEHOLDER""", { rs, _ -> rs.getString(1) })

        val factPhR = factPh.flatMap { extractNamesPlaceholder(it) }.toSet()

        val phFunNotInFact = phFun.minus(factPhR)

        phFunNotInFact
            .sorted()
            .forEach {
                logger.warn("'$it' found unused placeholder")
            }

        val factNotInPhFun = factPhR.minus(phFun).sorted()

        require(factNotInPhFun.isEmpty()) { "${factNotInPhFun.size} place holders without function $factNotInPhFun" }

    }
}