package br.com.ufpe.course.post.controller.impl

import br.com.ufpe.course.post.controller.PostController
import br.com.ufpe.course.post.service.PostService
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PostControllerImpl(
    private val postService: PostService
) : PostController {

    @GetMapping(path=["/posts/user/{id}"])
    override fun getAllByUser(@PathVariable id: Int): MappingJacksonValue =
        MappingJacksonValue(postService.findAllByUserId(id))
            .also {
                it.filters = SimpleFilterProvider().addFilter(
                    "PostFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept("description")
                    )
            }


}