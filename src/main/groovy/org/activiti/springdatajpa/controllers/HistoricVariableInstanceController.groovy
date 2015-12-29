package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.HistoricVariableInstanceRepository
import org.activiti.springdatajpa.models.HistoricVariableInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-variable-instances')
class HistoricVariableInstanceController extends AbstractRestController<HistoricVariableInstance, String> {

    @Autowired
    HistoricVariableInstanceController(HistoricVariableInstanceRepository repo) {
        super(repo)
    }
}

