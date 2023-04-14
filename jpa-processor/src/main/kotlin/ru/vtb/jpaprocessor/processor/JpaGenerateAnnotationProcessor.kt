package ru.vtb.jpaprocessor.processor

import ru.vtb.processor.abstraction.model.AnnotatedEntityClass
import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.AbstractGenerationProcessor

import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

@SupportedAnnotationTypes("ru.vtb.processor.annotation.GenerateJpa")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class JpaGenerateAnnotationProcessor :
    AbstractGenerationProcessor<GeneratedJpaRepositoryClass>() {

    override fun generatedClassInfo(typeElement: TypeElement): GeneratedJpaRepositoryClass =
        GeneratedJpaRepositoryClass(AnnotatedEntityClass(typeElement))

    override fun textGenerator(generatedClassData: GeneratedJpaRepositoryClass): String {
        val calculatePkClass = generatedClassData.annotatedClass.calculateIdClass(processingEnv).getOrElse {
            log(Diagnostic.Kind.ERROR, it.message)
            ""
        }
        //lang=java
        return """package ${generatedClassData.generatedPackageName()};
            
import ru.vtb.processor.annotation.GenerateByGeneric;            
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
   
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    
@Repository
@GenerateByGeneric
public interface ${generatedClassData.generatedClassName()} extends 
JpaRepository<${generatedClassData.annotatedClass.name()}, $calculatePkClass> 
{
    
@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
@Override
<S extends ${generatedClassData.annotatedClass.name()}> S save(S entity);


@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
@Override
<S extends ${generatedClassData.annotatedClass.name()}> List<S> saveAll(Iterable<S> entities);

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
@Override
void deleteById($calculatePkClass pk);

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
@Override
void deleteAllByIdInBatch(Iterable<$calculatePkClass> pkS);

}
"""
    }


}