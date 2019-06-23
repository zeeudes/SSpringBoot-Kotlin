package br.com.ufpe.course.post.repository

import br.com.ufpe.course.post.domain.Post
import br.com.ufpe.course.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Int> {
    fun findAllByUser(user: User): List<Post>
}