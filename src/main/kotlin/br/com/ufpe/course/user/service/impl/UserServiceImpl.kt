package br.com.ufpe.course.user.service.impl

import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.repository.UserRepository
import br.com.ufpe.course.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun findAll(): List<User> = userRepository.findAll()
    override fun save(user: User): User = userRepository.saveAndFlush(user)
    override fun findOne(id: Int): User = userRepository.getOne(id)
    override fun remove(id: Int): User = findOne(id)
        .copy(isDeleted=true)
        .let { save(it) }
}