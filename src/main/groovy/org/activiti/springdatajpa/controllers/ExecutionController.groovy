package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Execution
import org.activiti.springdatajpa.repositories.ExecutionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/executions')
class ExecutionController extends AbstractRestController<ExecutionRepository, Execution, String> {

}

