package ru.vtb.jpaprocessor.processor

import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@SupportedAnnotationTypes("com.evilcorp.orisnull.annotation.OrIsNullRepository")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@Deprecated("")
class OrIsNullProcessor : AbstractProcessor() {
    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
//        for (orIsNullAnnotation in annotations) {
//            val annotatedInterfaces = roundEnv.getElementsAnnotatedWith(orIsNullAnnotation)
//            for (orIsNullRepository in annotatedInterfaces) {
//                val orIsNullInterface: IAnnotatedClass = AnnotatedClass(orIsNullRepository)
//                val methods = orIsNullRepository
//                        .enclosedElements
//                        .stream()
//                        .filter { e: Element -> e.kind == ElementKind.METHOD }
//                        .map { queryMethodCandidate: Element? ->
//                            AnnotatedOrIsNullSearchMethod(
//                                    queryMethodCandidate!!, processingEnv.typeUtils
//                            )
//                        }
//                        .collect(Collectors.toList())
//                val searchGenerator = TemplateSearchServiceGenerator(
//                        orIsNullInterface,
//                        methods
//                )
//                searchGenerator.toFiler(processingEnv.filer)
//            }
//        }
        return true
    }
}