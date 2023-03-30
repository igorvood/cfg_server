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

    override fun generatedClass(typeElement: TypeElement): GeneratedJpaRepositoryClass =         GeneratedJpaRepositoryClass(AnnotatedClass(typeElement))

    override fun generateText1(GeneratedClass: GeneratedJpaRepositoryClass): String          =
        """package ${GeneratedClass.generatedPackageName()};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${GeneratedClass.generatedClassName()} extends JpaRepository<${GeneratedClass.annotatedClass.name()}, String> {
}
"""


}