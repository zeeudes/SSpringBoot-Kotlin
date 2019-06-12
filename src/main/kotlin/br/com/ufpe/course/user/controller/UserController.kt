package br.com.ufpe.course.user.controller

import br.com.ufpe.course.user.domain.User
import org.springframework.http.ResponseEntity.BodyBuilder

interface UserController {

    fun create(user: User): BodyBuilder
    fun delete(id: Int)
    fun getAll(): List<User>
    fun getOne(id: Int): User?
}