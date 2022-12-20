package ru.vtb.configuration.server.rest.handle

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class RestResponseEntityExceptionHandlere: ResponseEntityExceptionHandler() {


    @ExceptionHandler(value = [Exception::class])
    fun handleControllerException(req: HttpServletRequest, ex: Throwable): ResponseEntity<String> {
        return ResponseEntity(ex.message, null, HttpStatus.BAD_REQUEST)
    }
}