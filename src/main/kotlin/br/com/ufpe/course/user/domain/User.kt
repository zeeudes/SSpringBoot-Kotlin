package br.com.ufpe.course.user.domain

import org.springframework.hateoas.RepresentationModel

data class User(
        val id: Int? = null,
        val name: String,
        val birthDate: Long
) : RepresentationModel<User>()