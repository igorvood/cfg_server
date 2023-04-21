package ru.vtb.jpaprocessor.kotlin


import com.google.auto.service.AutoService
import ru.vtb.processor.abstraction.AbstractCommonGenerationProcessor
import ru.vtb.processor.abstraction.model.AnnotatedEntityClass
import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.getAllInterfaces
import ru.vtb.processor.abstraction.model.abstraction.getDirectlyImplementsInterface
import ru.vtb.processor.annotation.GenerateByGeneric
import ru.vtb.processor.annotation.MyTwoGeneric
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.DeclaredType
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


            val modifiers = it.modifiers

            val generatedJpaRepositoryClass = GeneratedJpaRepositoryClass(AnnotatedEntityClass(it))

            val className = it.simpleName.toString()
            val pack = elementUtils.getPackageOf(it).toString()
            generateClass(it, className, pack, generatedJpaRepositoryClass, processingEnv)

            messager.printMessage(
                Diagnostic.Kind.WARNING,
                "${this.javaClass.canonicalName}: лФОДЫРВАдлфыВРОАДЫВЛФОар"
            )
        }
        return true
    }

    private fun generateClass(
        elem: Element,
        className: String,
        pack: String,
        generatedJpaRepositoryClass: GeneratedJpaRepositoryClass,
        processingEnv: ProcessingEnvironment
    ) {

        val myTwoGenericMeta = elem.getDirectlyImplementsInterface(MyTwoGeneric::class.java)

        val typeMirror = if (myTwoGenericMeta.size == 1)
            myTwoGenericMeta.toList()[0] as                        DeclaredType
        else {
            val err =
                "${this.javaClass.canonicalName}: $className must directly implements interface ${MyTwoGeneric::class.java.canonicalName}"
            messager.printMessage(
                Diagnostic.Kind.ERROR,
                err
            )
            throw java.lang.IllegalArgumentException(err)
        }

        val fileName = "GeneratedByGeneric_$className"
        val fileContent = """package  ru.vtb.configuration.server.dataEntity.genRest.generic.$className
fun asdasdsa() ="dasdads"
fun f1(): ${((typeMirror.typeArguments[0] as DeclaredType).asElement() as TypeElement).qualifiedName.toString()}?  = null
fun f2(): ${((typeMirror.typeArguments[1] as DeclaredType).asElement() as TypeElement).qualifiedName.toString()}?  = null

"""


//            KotlinImmutableDtoClassBuilder(className, pack, generatedJpaRepositoryClass, processingEnv).getContent()

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
        val file = File(kaptKotlinGeneratedDir, "$fileName.kt")

        file.writeText(fileContent)
    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}