package br.com.ufpe.course

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

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
