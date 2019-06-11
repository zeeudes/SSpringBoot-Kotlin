package br.com.ufpe.course.user.domain

import java.util.*

data class User(
        val id: Int,
        val name: String,
        val birthDate: Date)