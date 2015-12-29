package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.ProcessDefinition
import org.activiti.springdatajpa.repositories.ProcessDefinitionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/process-definitions')
class ProcessDefinitionController extends AbstractRestController<ProcessDefinition, String> {

    @Autowired
    ProcessDefinitionController(ProcessDefinitionRepository repo) {
        super(repo)
    }
}

