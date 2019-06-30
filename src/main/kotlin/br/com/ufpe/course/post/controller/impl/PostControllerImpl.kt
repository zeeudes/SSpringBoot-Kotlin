package br.com.ufpe.course.post.controller.impl

import br.com.ufpe.course.post.controller.PostController
import br.com.ufpe.course.post.domain.Post
import br.com.ufpe.course.post.service.PostService
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PostControllerImpl(
    private val postService: PostService
) : PostController {

    @GetMapping(path = ["/posts/user/{id}"])
    override fun getAllByUser(@PathVariable id: Int): MappingJacksonValue =
        postService.findAllByUserId(id)
            .map { it.toFilter() }
            .let { list ->
                MappingJacksonValue(list).also { mapping ->
                    mapping.filters = SimpleFilterProvider().addFilter(
                        "PostFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept(
                            "description",
                            "id"
                        )
                    )
                }
            }

    @PostMapping(path = ["/posts/user/{id}"])
    override fun create(
        @PathVariable id: Int,
        @RequestBody post: Post
    ): ResponseEntity<String> =
        postService.create(id, post).run {
            ResponseEntity("Post has been created!", CREATED)
        }
}