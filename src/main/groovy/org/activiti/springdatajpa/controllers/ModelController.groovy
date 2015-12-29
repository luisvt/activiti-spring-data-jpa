package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Model
import org.activiti.springdatajpa.repositories.ModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/models')
class ModelController extends AbstractRestController<Model, String> {

    @Autowired
    ModelController(ModelRepository repo) {
        super(repo)
    }
}

