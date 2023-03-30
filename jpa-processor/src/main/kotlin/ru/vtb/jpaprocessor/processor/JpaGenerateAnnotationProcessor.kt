package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.annotation.GenerateJpa
import ru.vtb.jpaprocessor.generator.model.AnnotatedClass
import java.io.OutputStreamWriter
import java.io.Writer
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedAnnotationTypes("ru.vtb.jpaprocessor.annotation.GenerateJpa")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class JpaGenerateAnnotationProcessor : AbstractProcessor() {

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val of = setOf(GenerateJpa::class.java.canonicalName)
        return super.getSupportedAnnotationTypes()
    }

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {



        val flatMap1 = annotations
            .flatMap { orIsNullAnnotation -> roundEnv.getElementsAnnotatedWith(orIsNullAnnotation) }
            .filterIsInstance<TypeElement>()
        val flatMap = flatMap1
            .firstOrNull()?.let { generateBy ->

                val annotatedClass = AnnotatedClass(generateBy)
                val generatedClassName =annotatedClass.shortName()+"GeneratedRepository"
                val generatedPackageName = "${annotatedClass.packageName()}.generated"
                processingEnv.messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Generate class $generatedClassName by class ${annotatedClass.name()}")
                val filer = processingEnv.filer

                val sourceFile = filer.createSourceFile("$generatedPackageName.$generatedClassName")
                val out: Writer = OutputStreamWriter(sourceFile.openOutputStream())
                out.write(generateText(generatedPackageName, generatedClassName, annotatedClass))
                out.close()
            }

        return true
    }


    private fun generateText(generatedPackageName: String,
                             generatedClassName: String,
                             annotatedClass: AnnotatedClass): String{
        val code ="""package ${generatedPackageName};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface $generatedClassName extends JpaRepository<${annotatedClass.name()}, String> {
}
"""
return code
    }

}