package br.com.ufpe.course.post.controller

import org.springframework.http.converter.json.MappingJacksonValue

interface PostController {
    fun getAllByUser(id: Int): MappingJacksonValue
}