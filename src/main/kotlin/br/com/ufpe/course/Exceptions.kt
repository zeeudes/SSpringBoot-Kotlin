package br.com.ufpe.course

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.MethodArgumentNotValidException
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

@ResponseStatus(BAD_REQUEST)
class BadRequest(
    message: String, cause: Throwable? = null,
    enableSuppression: Boolean = false,
    writableStackTrace: Boolean = false
) : RuntimeException(
    message,
    cause,
    enableSuppression,
    writableStackTrace
)

@ResponseStatus(UNPROCESSABLE_ENTITY)
class UnprocessableEntity(
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

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return ResponseEntity(
            APIError(
                message = ex.message,
                details = request.getDescription(false),
                type = BAD_REQUEST
            ),
            BAD_REQUEST
        )
    }

    @ExceptionHandler(
        NotFound::class,
        JpaObjectRetrievalFailureException::class,
        EmptyResultDataAccessException::class
    )
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

    @ExceptionHandler(BadRequest::class)
    fun handleBadRequestException(ex: Exception, request: WebRequest): ResponseEntity<APIError> {
        return ResponseEntity(
            APIError(
                message = ex.message,
                details = request.getDescription(false),
                type = BAD_REQUEST
            ),
            BAD_REQUEST
        )
    }

    @ExceptionHandler(UnprocessableEntity::class)
    fun handleUnprocessableEntityException(ex: Exception, request: WebRequest): ResponseEntity<APIError> {
        return ResponseEntity(
            APIError(
                message = ex.message,
                details = request.getDescription(false),
                type = UNPROCESSABLE_ENTITY
            ),
            UNPROCESSABLE_ENTITY
        )
    }
}

class APIError(
        val message: String?,
        val timestamp: Long = now().toEpochMilli(),
        val details: String?,
        val type: HttpStatus
)
