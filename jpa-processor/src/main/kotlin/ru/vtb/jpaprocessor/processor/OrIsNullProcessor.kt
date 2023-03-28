package ru.vtb.jpaprocessor.processor

import ru.vtb.jpaprocessor.generator.model.AnnotatedOrIsNullClass
import ru.vtb.jpaprocessor.generator.model.AnnotatedOrIsNullSearchMethod
import ru.vtb.jpaprocessor.generator.model.OrIsNullClass
import ru.vtb.jpaprocessor.generator.template.TemplateSearchServiceGenerator
import java.util.stream.Collectors
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("com.evilcorp.orisnull.annotation.OrIsNullRepository")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class OrIsNullProcessor : AbstractProcessor() {
    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        for (orIsNullAnnotation in annotations) {
            val annotatedInterfaces = roundEnv.getElementsAnnotatedWith(orIsNullAnnotation)
            for (orIsNullRepository in annotatedInterfaces) {
                val orIsNullInterface: OrIsNullClass = AnnotatedOrIsNullClass(orIsNullRepository)
                val methods = orIsNullRepository
                        .enclosedElements
                        .stream()
                        .filter { e: Element -> e.kind == ElementKind.METHOD }
                        .map { queryMethodCandidate: Element? ->
                            AnnotatedOrIsNullSearchMethod(
                                    queryMethodCandidate!!, processingEnv.typeUtils
                            )
                        }
                        .collect(Collectors.toList())
                val searchGenerator = TemplateSearchServiceGenerator(
                        orIsNullInterface,
                        methods
                )
                searchGenerator.toFiler(processingEnv.filer)
            }
        }
        return true
    }
}