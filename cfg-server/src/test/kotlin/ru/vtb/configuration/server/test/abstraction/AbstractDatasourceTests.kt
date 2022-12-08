package ru.vtb.configuration.server.test.abstraction

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import java.io.File
import java.util.*

val delimiterScripts = "/"
val pathSeparator = "/"


abstract class AbstractDatasourceTests : AbstractTests() {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    val setupClass = "setup.sql"
    val setupTest = "setup.each.sql"

    val teardownClass = "teardown.sql"
    val teardownTest = "teardown.each.sql"

    val javaClass = this::class.java
    val fullPathToScripts = javaClass.name.replace(".", pathSeparator)

    @BeforeAll
    fun beforeAll() = run {
        afterAll()
        runScriptsFromFile(setupClass)
    }

    @AfterAll
    fun afterAll() = runScriptsFromFile(teardownClass)


    @BeforeEach
    fun beforeEach() = run {
        afterEach()
        runScriptsFromFile(setupTest)
    }

    @AfterEach
    fun afterEach() = runScriptsFromFile(teardownTest)

    private fun runScriptsFromFile(fileName: String) {
        val fullFilename = fullPathToScripts + pathSeparator + fileName
        val file = Optional.ofNullable(javaClass.classLoader.getResource(fullFilename))
            .map { File(it.path) }
            .orElseGet { throw java.lang.IllegalArgumentException("Unable to read $fullFilename") }

        file.bufferedReader().readLines().joinToString("\n").split(delimiterScripts)
            .forEach { sql -> jdbcTemplate.execute(sql) }
    }


}