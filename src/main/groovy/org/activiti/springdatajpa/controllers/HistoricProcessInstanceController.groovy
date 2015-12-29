package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.HistoricProcessInstance
import org.activiti.springdatajpa.repositories.HistoricProcessInstanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-process-instances')
class HistoricProcessInstanceController extends AbstractRestController<HistoricProcessInstance, String> {

    @Autowired
    HistoricProcessInstanceController(HistoricProcessInstanceRepository repo) {
        super(repo)
    }
}

