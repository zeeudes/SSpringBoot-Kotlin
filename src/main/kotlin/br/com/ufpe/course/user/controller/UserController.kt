package br.com.ufpe.course.user.controller

import br.com.ufpe.course.user.domain.User
import org.springframework.hateoas.Resource
import org.springframework.http.ResponseEntity

interface UserController {
    fun create(user: User): ResponseEntity<String>
    fun delete(id: Int)
    fun getAll(): List<User>
    fun getOne(id: Int): Resource<User>
}