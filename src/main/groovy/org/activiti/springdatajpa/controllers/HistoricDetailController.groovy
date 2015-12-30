package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.HistoricDetail
import org.activiti.springdatajpa.repositories.HistoricDetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-details')
class HistoricDetailController extends AbstractRestController<HistoricDetailRepository, HistoricDetail, String> {

}

