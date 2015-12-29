package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.ByteArray
import org.activiti.springdatajpa.repositories.ByteArrayRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/byte-arrays')
class ByteArrayController extends AbstractRestController<ByteArray, String> {

    @Autowired
    ByteArrayController(ByteArrayRepository repo) {
        super(repo)
    }
}

