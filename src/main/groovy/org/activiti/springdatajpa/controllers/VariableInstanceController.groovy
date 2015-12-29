package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.VariableInstanceRepository
import org.activiti.springdatajpa.models.VariableInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/variable-instances')
class VariableInstanceController extends AbstractRestController<VariableInstance, String> {

    @Autowired
    VariableInstanceController(VariableInstanceRepository repo) {
        super(repo)
    }
}

