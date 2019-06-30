package br.com.ufpe.course.post.service

import br.com.ufpe.course.post.domain.Post

interface PostService {
    fun findAllByUserId(id: Int): List<Post>
    fun create(id: Int, post: Post): Post
}