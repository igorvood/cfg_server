package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.annotation.GenerateJpa
import ru.vtb.jpaprocessor.generator.model.AnnotatedClass
import ru.vtb.jpaprocessor.generator.model.GeneratedJpaRepositoryClass
import ru.vtb.jpaprocessor.processor.abstraction.AbstractGenerationProcessor
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("ru.vtb.jpaprocessor.annotation.GenerateJpa")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class JpaGenerateAnnotationProcessor :
    AbstractGenerationProcessor<GenerateJpa, AnnotatedClass, GeneratedJpaRepositoryClass>() {

    override fun generatedClassInfo(typeElement: TypeElement): GeneratedJpaRepositoryClass =
        GeneratedJpaRepositoryClass(AnnotatedClass(typeElement))

    override fun textGenerator(generatedClassData: GeneratedJpaRepositoryClass): String =
        """package ${generatedClassData.generatedPackageName()};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${generatedClassData.generatedClassName()} extends JpaRepository<${generatedClassData.annotatedClass.name()}, String> {
}
"""


}