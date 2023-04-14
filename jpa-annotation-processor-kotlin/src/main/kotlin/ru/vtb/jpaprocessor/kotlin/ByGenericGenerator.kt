package ru.vtb.jpaprocessor.kotlin


import com.google.auto.service.AutoService
import ru.vtb.processor.abstraction.AbstractCommonGenerationProcessor
import ru.vtb.processor.abstraction.model.AnnotatedEntityClass
import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.annotation.GenerateByGeneric
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@AutoService(Processor::class) // For registering the service
@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
@SupportedOptions(ByGenericGenerator.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class ByGenericGenerator : AbstractCommonGenerationProcessor<GeneratedJpaRepositoryClass>() {

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(GenerateByGeneric::class.java.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    override fun process(set: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {

        val elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(GenerateByGeneric::class.java)
                elementsAnnotatedWith.forEach {
            val generatedJpaRepositoryClass = GeneratedJpaRepositoryClass(AnnotatedEntityClass(it))

            val className = it.simpleName.toString()
            val pack = elementUtils.getPackageOf(it).toString()
            generateClass(className, pack, generatedJpaRepositoryClass, processingEnv)

            messager.printMessage(
                Diagnostic.Kind.WARNING,
                "${this.javaClass.canonicalName}: лФОДЫРВАдлфыВРОАДЫВЛФОар"
            )
        }
        return true
    }

    private fun generateClass(
        className: String,
        pack: String,
        generatedJpaRepositoryClass: GeneratedJpaRepositoryClass,
        processingEnv: ProcessingEnvironment
    ) {
        val fileName = "GeneratedByGeneric_$className"
        val fileContent = "package  ru.vtb.configuration.server.dataEntity.genRest.generic.$className\n" +
                "fun asdasdsa() =\"dasdads\""
//            KotlinImmutableDtoClassBuilder(className, pack, generatedJpaRepositoryClass, processingEnv).getContent()

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
        val file = File(kaptKotlinGeneratedDir, "$fileName.kt")

        file.writeText(fileContent)
    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}