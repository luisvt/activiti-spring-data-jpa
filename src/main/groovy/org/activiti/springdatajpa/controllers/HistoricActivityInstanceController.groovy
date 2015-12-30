package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.HistoricActivityInstance
import org.activiti.springdatajpa.repositories.HistoricActivityInstanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-attachments')
class HistoricActivityInstanceController extends AbstractRestController<HistoricActivityInstanceRepository, HistoricActivityInstance, String> {

}

