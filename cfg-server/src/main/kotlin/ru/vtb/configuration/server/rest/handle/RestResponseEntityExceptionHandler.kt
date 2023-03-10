package ru.vtb.configuration.server.rest.handle

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class RestResponseEntityExceptionHandlere : ResponseEntityExceptionHandler() {


    @ExceptionHandler(value = [Exception::class])
    fun handleControllerException(req: HttpServletRequest, ex: Throwable): ResponseEntity<String> {
        val httpHeaders = HttpHeaders()
        httpHeaders["error"] = listOf(ex.message)
        return ResponseEntity(ex.message, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}