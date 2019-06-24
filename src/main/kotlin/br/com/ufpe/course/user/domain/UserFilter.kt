package br.com.ufpe.course.user.domain

import com.fasterxml.jackson.annotation.JsonFilter
import java.io.Serializable
import java.time.ZonedDateTime

@JsonFilter("UserFilter")
class UserFilter(
    val id: Int,
    val name: String,
    val birthDate: ZonedDateTime,
    val isDeleted: Boolean
) : Serializable