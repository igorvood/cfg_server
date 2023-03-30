package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.annotation.GenerateJpa
import ru.vtb.jpaprocessor.generator.model.AnnotatedClass
import ru.vtb.jpaprocessor.generator.model.GeneratedJpaRepositoryClass
import ru.vtb.jpaprocessor.processor.abstraction.AbstractGenerationProcessor
import java.io.OutputStreamWriter
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedAnnotationTypes("ru.vtb.jpaprocessor.annotation.GenerateJpa")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class JpaGenerateAnnotationProcessor : AbstractGenerationProcessor<GenerateJpa, AnnotatedClass, GeneratedJpaRepositoryClass>() {

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val flatMap1 = annotations
            .flatMap { orIsNullAnnotation -> roundEnv.getElementsAnnotatedWith(orIsNullAnnotation) }
            .filterIsInstance<TypeElement>()
        val flatMap = flatMap1
            .firstOrNull()?.let { generateBy ->
                val annotatedClass = AnnotatedClass(generateBy)
                val generatedJpaRepositoryClass = GeneratedJpaRepositoryClass(annotatedClass)

                val out = processingEnv.filer
                    .createSourceFile(generatedJpaRepositoryClass.fullGeneratedName())
                    .let { OutputStreamWriter(it.openOutputStream()) }



                out.write(generateText(generatedJpaRepositoryClass))
                out.close()
            }

        return true
    }


    private fun generateText(
        generatedJpaRepositoryClass: GeneratedJpaRepositoryClass,
        ): String{
        processingEnv.messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, "Generate class ${generatedJpaRepositoryClass.generatedClassName()} by class ${generatedJpaRepositoryClass.annotatedClass.name()}")
        val code ="""package ${generatedJpaRepositoryClass.generatedPackageName()};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${generatedJpaRepositoryClass.generatedClassName()} extends JpaRepository<${generatedJpaRepositoryClass.annotatedClass.name()}, String> {
}
"""
return code
    }

}