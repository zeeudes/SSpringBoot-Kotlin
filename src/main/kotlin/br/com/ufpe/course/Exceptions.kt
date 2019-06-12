package br.com.ufpe.course

import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant.now
import kotlin.Exception
import kotlin.RuntimeException

@ResponseStatus(NOT_FOUND)
class NotFound(
        message: String, cause: Throwable? = null,
        enableSuppression: Boolean = false,
        writableStackTrace: Boolean = false
) : RuntimeException(
        message,
        cause,
        enableSuppression,
        writableStackTrace
)

@RestControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<APIError> {
        return ResponseEntity(
                APIError(
                        message = ex.message,
                        details = request.getDescription(false),
                        type = INTERNAL_SERVER_ERROR
                ),
                INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(NotFound::class)
    fun handleNotFoundException(ex: Exception, request: WebRequest): ResponseEntity<APIError> {
        return ResponseEntity(
                APIError(
                        message = ex.message,
                        details = request.getDescription(false),
                        type = NOT_FOUND
                ),
                NOT_FOUND
        )
    }
}

class APIError(
        val message: String?,
        val timestamp: Long = now().toEpochMilli(),
        val details: String?,
        val type: HttpStatus
)
