package br.com.ufpe.course.user.controller.impl

import br.com.ufpe.course.user.controller.UserController
import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.service.UserService
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl(
    private val userService: UserService,
    private val messageSource: MessageSource
) : UserController {

    @PostMapping(path = ["/users"])
    override fun create(@RequestBody user: User): ResponseEntity<String> {
        userService.save(user)
        return ResponseEntity("User has been created!", CREATED)
    }

    @DeleteMapping(path = ["/users/{id}"])
    override fun delete(@PathVariable id: Int) {
        userService.remove(id)
    }

    @GetMapping(path = ["/users"])
    override fun getAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping(path = ["/users/{id}"])
    override fun getOne(@PathVariable id: Int): Resource<User> {
        return Resource(userService.findOne(id))
            .also {
                it.add(linkTo(methodOn(this.javaClass).getOne(id))
                    .withSelfRel()
                    .withRel("get-one")
                )
            }
    }

    @GetMapping(path=["/hello-world-internationalized"])
    fun helloWorldInternationalized(): String {
        return messageSource.getMessage("message.good.morning", null, LocaleContextHolder.getLocale())
    }
}