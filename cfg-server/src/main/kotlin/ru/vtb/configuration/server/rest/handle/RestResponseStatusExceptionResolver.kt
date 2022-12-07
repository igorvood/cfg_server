package ru.vtb.configuration.server.rest.handle

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//@Component
class RestResponseStatusExceptionResolver : AbstractHandlerExceptionResolver() {
    override fun doResolveException(
        request: HttpServletRequest,
        response: HttpServletResponse, handler: Any?, ex: Exception
    ): ModelAndView? {
        try {

            val message = getRoot(ex)

//            val handleIllegalArgument = handleIllegalArgument(
//                message, request, response, handler
//            )
            response.sendError(1, message.message)
            return null;//handleIllegalArgument

        } catch (handlerException: Exception) {
            Companion.logger.warn("Handling of [{}] resulted in Exception", ex.javaClass.name, handlerException)
        }
        return null
    }

    private tailrec fun getRoot(ex: Throwable):Throwable {
        return if (ex.cause!=null)
            getRoot(ex.cause!!)
        else ex
    }

    @Throws(Exception::class)
    private fun handleIllegalArgument(
        ex: Throwable,
        request: HttpServletRequest, response: HttpServletResponse, handler: Any?
    ): ModelAndView {
        val accept = request.getHeader(HttpHeaders.ACCEPT)
        response.sendError(HttpServletResponse.SC_CONFLICT)
        response.setHeader("ContentType", accept)
        val modelAndView = ModelAndView("error")
        modelAndView.addObject("error", ex.message)
        return modelAndView
    }

    /** Prepares error object based on the provided accept type.
     * @param accept The Accept header present in the request.
     * @return The response to return
     * @throws JsonProcessingException
     */
    @Throws(JsonProcessingException::class)
    private fun prepareErrorResponse(accept: String): String {
        val error: MutableMap<String, String> = HashMap()
        error["Error"] = "Application specific error message"
        val response: String
        response = if (MediaType.APPLICATION_JSON_VALUE == accept) {
            ObjectMapper().writeValueAsString(error)
        } else {
            "new XmlMapper().writeValueAsString(error);"
        }
        return response
    }

    companion object {
        private val logger = LoggerFactory.getLogger(RestResponseStatusExceptionResolver::class.java)
    }
}