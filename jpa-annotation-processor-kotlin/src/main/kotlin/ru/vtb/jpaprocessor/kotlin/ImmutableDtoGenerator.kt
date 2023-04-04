package ru.vtb.jpaprocessor.kotlin


import com.google.auto.service.AutoService
import ru.vtb.processor.abstraction.model.AnnotatedEntityClass
import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.annotation.GenerateJpa
//import io.navendra.annotation.GreetingGenerator
//import ru.vtb.jpaprocessor.kotlin.KotlinClassBuilder
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class) // For registering the service
@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
@SupportedOptions(ImmutableDtoGenerator.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class ImmutableDtoGenerator: AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(GenerateJpa::class.java.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    override fun process(set: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {

        roundEnvironment?.
        getElementsAnnotatedWith(GenerateJpa::class.java)?.
        forEach {
            val generatedJpaRepositoryClass = GeneratedJpaRepositoryClass(AnnotatedEntityClass(it))

            val className = it.simpleName.toString()
                val pack = processingEnv.elementUtils.getPackageOf(it).toString()
                generateClass(className, pack, generatedJpaRepositoryClass)
            }
        return true
    }

    private fun generateClass(className: String, pack: String, generatedJpaRepositoryClass: GeneratedJpaRepositoryClass){
        val fileName = "Generated_$className"
        val fileContent = KotlinImmutableDtoClassBuilder(className, pack, generatedJpaRepositoryClass).getContent()

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
        val file = File(kaptKotlinGeneratedDir, "$fileName.kt")

        file.writeText(fileContent)
    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}