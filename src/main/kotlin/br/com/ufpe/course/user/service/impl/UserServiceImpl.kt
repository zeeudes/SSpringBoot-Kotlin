package br.com.ufpe.course.user.service.impl

import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.repository.UserRepository
import br.com.ufpe.course.user.service.UserService
import org.springframework.stereotype.Component

@Component
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findAll() = userRepository.findAll()
    override fun save(user: User) = userRepository.saveAndFlush(user)
    override fun findOne(id: Int) = userRepository.getOne(id)
    override fun remove(id: Int) = userRepository.deleteById(id)
}