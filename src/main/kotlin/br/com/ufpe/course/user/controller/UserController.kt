package br.com.ufpe.course.user.controller

import br.com.ufpe.course.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue

interface UserController {
    fun create(user: User): ResponseEntity<String>
    fun delete(id: Int): ResponseEntity<String>
    fun getAll(): List<User>
    fun getOne(id: Int): User
    fun getBirthDay(id: Int): MappingJacksonValue
}