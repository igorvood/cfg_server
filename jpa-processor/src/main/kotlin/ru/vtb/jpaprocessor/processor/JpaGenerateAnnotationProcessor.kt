package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.generator.model.AnnotatedEntityClass
import ru.vtb.jpaprocessor.generator.model.GeneratedJpaRepositoryClass
import ru.vtb.jpaprocessor.processor.abstraction.AbstractGenerationProcessor
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedAnnotationTypes("ru.vtb.jpaprocessor.annotation.GenerateJpa")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class JpaGenerateAnnotationProcessor :
    AbstractGenerationProcessor<GeneratedJpaRepositoryClass>() {

    override fun generatedClassInfo(typeElement: TypeElement): GeneratedJpaRepositoryClass =
        GeneratedJpaRepositoryClass(AnnotatedEntityClass(typeElement))

    override fun textGenerator(generatedClassData: GeneratedJpaRepositoryClass): String {
        val calculateIdClass = generatedClassData.annotatedClass.calculateIdClass(processingEnv).getOrElse {
            processingEnv.messager.printMessage(
                Diagnostic.Kind.ERROR,
                it.message
            )
            ""
        }

        return """package ${generatedClassData.generatedPackageName()};
    
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    
    @Repository
    public interface ${generatedClassData.generatedClassName()} extends JpaRepository<${generatedClassData.annotatedClass.name()}, $calculateIdClass> {
    }
    """
    }


}