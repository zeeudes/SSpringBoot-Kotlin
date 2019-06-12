package br.com.ufpe.course.user.service.impl

import br.com.ufpe.course.NotFound
import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.service.UserService
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class UserServiceImpl : UserService {

    init {
        users.addAll(listOf(
                User(1, "Adam", Instant.now().toEpochMilli()),
                User(2, "Eve", Instant.now().toEpochMilli()),
                User(3, "Jack", Instant.now().toEpochMilli())
        ))
    }

    override fun findAll() = users
    override fun save(user: User) = user.copy(id = user.id ?: users.count().plus(1)).also { users.add(it) }
    override fun findOne(id: Int) = users.find { it.id == id } ?: throw NotFound("User not found!")
    override fun remove(id: Int) = users.remove(findOne(id))

    companion object {
        private val users: MutableList<User> = mutableListOf()
    }
}