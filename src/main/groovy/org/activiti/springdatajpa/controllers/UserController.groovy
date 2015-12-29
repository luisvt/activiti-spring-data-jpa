package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.models.User
import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/users')
class UserController extends AbstractRestController<User, String> {

    @Autowired
    UserController(UserRepository repo) {
        super(repo)
    }
}

