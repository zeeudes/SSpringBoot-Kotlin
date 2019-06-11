package br.com.ufpe.course.user.controller.impl

import br.com.ufpe.course.user.controller.UserController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class UserControllerImpl : UserController {

    @RequestMapping(method = [RequestMethod.POST], path = ["/user"])
    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @RequestMapping(method = [RequestMethod.DELETE], path = ["/user/"])
    override fun delete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOne() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}