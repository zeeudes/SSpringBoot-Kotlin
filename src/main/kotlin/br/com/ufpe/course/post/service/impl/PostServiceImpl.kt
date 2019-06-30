package br.com.ufpe.course.post.service.impl

import br.com.ufpe.course.BadRequest
import br.com.ufpe.course.post.domain.Post
import br.com.ufpe.course.post.repository.PostRepository
import br.com.ufpe.course.post.service.PostService
import br.com.ufpe.course.user.service.UserService
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    private val postRepository: PostRepository,
    private val userService: UserService
) : PostService {

    override fun create(id: Int, post: Post): Post =
        userService.findOne(id)
            .let { post.copy(user=it) }
            .also { postRepository.saveAndFlush(it) }

    override fun findAllByUserId(id: Int): List<Post> =
        userService.findOne(id)
        .let(postRepository::findAllByUser)
        .also { it.firstOrNull() ?: throw BadRequest("User has not written any posts yet!") }
}