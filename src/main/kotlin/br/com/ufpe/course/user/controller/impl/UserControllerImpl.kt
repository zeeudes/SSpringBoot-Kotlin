package br.com.ufpe.course.user.controller.impl

import br.com.ufpe.course.user.controller.UserController
import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.service.UserService
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.MappingJacksonValue
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

    @PostMapping(path=["/users"])
    override fun create(@RequestBody user: User) = userService.save(user)
        .run { ResponseEntity("User has been created!", CREATED) }

    @DeleteMapping(path=["/users/{id}"])
    override fun delete(@PathVariable id: Int) = userService.remove(id)
        .run { ResponseEntity("User has been deleted!", NO_CONTENT) }

    @GetMapping(path=["/users"])
    override fun getAll() = userService.findAll()

    @GetMapping(path=["/users/{id}/birthday"])
    override fun getBirthDay(@PathVariable id: Int): MappingJacksonValue =
        MappingJacksonValue(userService.findOne(id).toFilter())
            .also { it.filters = SimpleFilterProvider()
                .addFilter("UserFilter", SimpleBeanPropertyFilter
                    .filterOutAllExcept("birthDate")
                )
            }

    @GetMapping(path=["/users/{id}"])
    override fun getOne(@PathVariable id: Int): Resource<User> =
        Resource(userService.findOne(id))
            .also {
                it.add(
                    linkTo(
                        methodOn(this.javaClass).getOne(id)
                    )
                        .withSelfRel()
                        .withRel("get-one")
                )
            }

    @GetMapping(path=["/hello-world-internationalized"])
    fun helloWorldInternationalized() = messageSource
        .getMessage("message.good.morning", null, LocaleContextHolder.getLocale())

}