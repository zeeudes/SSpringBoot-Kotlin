package br.com.ufpe.course.user.domain

data class User(
        val id: Int? = null,
        val name: String,
        val birthDate: Long
)