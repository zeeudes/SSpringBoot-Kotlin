package br.com.ufpe.course.user.controller.impl

import br.com.ufpe.course.user.controller.UserController
import br.com.ufpe.course.user.domain.User
import br.com.ufpe.course.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.BodyBuilder
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
class UserControllerImpl(private val userService: UserService) : UserController {

    @PostMapping(path = ["/user"])
    override fun create(@Valid @RequestBody user: User): BodyBuilder {

        val id = userService.save(user).id

       return ResponseEntity.created(
               ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(id)
                       .toUri()
       )
    }

    @DeleteMapping(path = ["/user/{id}"])
    override fun delete(@PathVariable id: Int) {
        userService.remove(id)
    }

    @GetMapping(path = ["/users"])
    override fun getAll(): List<User> {
        return userService.findAll()
    }

    @GetMapping(path = ["/user/{id}"])
    override fun getOne(@PathVariable id: Int): User? {
        return userService.findOne(id)
    }
}