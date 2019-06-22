package br.com.ufpe.course.post.domain

import br.com.ufpe.course.user.domain.User
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Post (
    @Id
    @GeneratedValue
    private val id: Int,
    private val description: String,
    @ManyToOne(fetch=LAZY)
    private val user: User
)