package br.com.ufpe.course.post.domain

import br.com.ufpe.course.user.domain.User
import com.fasterxml.jackson.annotation.JsonFilter

@JsonFilter("PostFilter")
class PostFilter (
    val id: Int,
    val description: String,
    val user: User
)