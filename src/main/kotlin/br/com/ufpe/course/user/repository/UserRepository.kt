package br.com.ufpe.course.user.repository

import br.com.ufpe.course.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int>