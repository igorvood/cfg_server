package ru.vtb.configuration.server.check

import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.reflect.Method

class TransactionTestBeanPostProcessor : BeanPostProcessor {

    val transactionalMethods = mutableMapOf<String, Array<Method>>()


    override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any? {
        val beanClass = bean.javaClass

        val annotatedMethods = beanClass.methods
            .filter { m -> m.isAnnotationPresent(Transactional::class.java) && m.getAnnotation(Transactional::class.java).propagation == Propagation.REQUIRES_NEW }

        val methods = if (beanClass.isAnnotationPresent(Transactional::class.java)) {
            val transactional = beanClass.getAnnotation(Transactional::class.java)
            if (transactional.propagation == Propagation.REQUIRES_NEW) {
                beanClass.methods
            } else arrayOf()
        } else arrayOf()

        val plus = methods.plus(annotatedMethods)
        if (plus.isNotEmpty()) {
            transactionalMethods[beanName] = plus
        }

        return super.postProcessAfterInitialization(bean, beanName)
    }
}