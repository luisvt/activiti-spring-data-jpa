package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Property
import org.activiti.springdatajpa.repositories.PropertyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/properties')
class PropertyController extends AbstractRestController<Property, String> {

    @Autowired
    PropertyController(PropertyRepository repo) {
        super(repo)
    }
}

