package ru.vtb.processor.abstraction

import ru.vtb.processor.abstraction.model.abstraction.AbstractGeneratedClass
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.tools.Diagnostic

abstract class AbstractCommonGenerationProcessor<GeneratedClass : AbstractGeneratedClass<*>> : AbstractProcessor() {

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    protected fun log(kind: Diagnostic.Kind, msg: CharSequence?) {
        processingEnv.messager.printMessage(kind, "${this.javaClass.canonicalName}: $msg")
    }
}