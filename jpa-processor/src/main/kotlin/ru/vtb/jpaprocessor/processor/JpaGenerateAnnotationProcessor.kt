package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.annotation.GenerateJpa
import java.io.OutputStreamWriter
import java.io.Writer
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

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
        val flatMap = flatMap1
            .firstOrNull()?.let {
                val filer = processingEnv.filer
                val sourceFile = filer.createSourceFile("ru.vtb.configuration.server.dataEntity.repo.generated.DictTopicOwnerEntityImpl")
                val out: Writer = OutputStreamWriter(sourceFile.openOutputStream())
                out.write(code)
                out.close()
            }

        return true
    }

    val code ="""package ru.vtb.configuration.server.dataEntity.repo.generated;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity;

@Repository
public interface DictTopicOwnerEntityImpl extends JpaRepository<DictTopicNodeEntity, String> {
}
"""
}