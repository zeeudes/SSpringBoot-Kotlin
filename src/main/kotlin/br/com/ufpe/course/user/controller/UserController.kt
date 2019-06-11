package br.com.ufpe.course.user.controller

interface UserController {

    fun create()
    fun delete(id: Int)
    fun getAll()
    fun getOne(id: Int)
}