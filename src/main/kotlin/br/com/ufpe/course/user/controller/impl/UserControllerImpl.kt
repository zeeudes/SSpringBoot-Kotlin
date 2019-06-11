package br.com.ufpe.course.user.controller.impl

import br.com.ufpe.course.user.controller.UserController
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl : UserController {

    @PostMapping(path = ["/user"])
    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @DeleteMapping(path = ["/user/{id}"])
    override fun delete(@PathVariable id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @GetMapping(path = ["/users"])
    override fun getAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @GetMapping(path = ["/user/{id}"])
    override fun getOne(@PathVariable id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}