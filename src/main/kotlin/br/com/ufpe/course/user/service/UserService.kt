package br.com.ufpe.course.user.service

import br.com.ufpe.course.user.domain.User

interface UserService {
    fun findAll(): List<User>
    fun save(user: User): User
    fun findOne(id: Int): User
    fun remove(id: Int)
}