package ru.vtb.configuration.server.delete

//import io.swagger.v3.oas.annotations.Operation
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//import ru.vtb.configuration.server.dataEntity.generated.DictTopicNodeEntityGeneratedRepository
//import ru.vtb.configuration.server.dataEntity.toImmutable

//@RestController
//class DictTopicNodeEntityGeneratedRestApi(
//    val DictTopicNodeEntityGeneratedRepository: DictTopicNodeEntityGeneratedRepository
//) {
//
//    @Operation(summary = "Генерированное API. DictTopicNodeEntity", tags = ["DictTopicNodeEntity"])
//    @GetMapping("/DictTopicNodeEntity/findAll")
//    fun findAll() = DictTopicNodeEntityGeneratedRepository.findAll().map { it.toImmutable() }
//
//}