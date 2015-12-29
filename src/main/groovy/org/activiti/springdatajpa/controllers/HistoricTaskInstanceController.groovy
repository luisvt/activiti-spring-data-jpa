package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.repositories.HistoricTaskInstanceRepository
import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.HistoricTaskInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-task-instances')
class HistoricTaskInstanceController extends AbstractRestController<HistoricTaskInstance, String> {

    @Autowired
    HistoricTaskInstanceController(HistoricTaskInstanceRepository repo) {
        super(repo)
    }
}

