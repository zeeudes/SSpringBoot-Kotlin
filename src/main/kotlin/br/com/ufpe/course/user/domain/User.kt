package br.com.ufpe.course.user.domain

import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class User(
        val id: Int? = null,
        @Size(min=2)
        val name: String,
        val birthDate: Long
)