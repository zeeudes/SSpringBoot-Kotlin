package br.com.ufpe.course.post.controller

import br.com.ufpe.course.post.domain.Post
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PostController {
    fun getAllByUser(id: Int): MappingJacksonValue
    fun create(@PathVariable id: Int, @RequestBody post: Post): ResponseEntity<String>
}