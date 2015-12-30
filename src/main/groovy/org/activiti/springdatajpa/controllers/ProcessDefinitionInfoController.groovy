package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.models.ProcessDefinitionInfo
import org.activiti.springdatajpa.repositories.ProcessDefinitionInfoRepository
import org.activiti.springdatajpa.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/process-definition-infos')
class ProcessDefinitionInfoController extends AbstractRestController<ProcessDefinitionInfoRepository, ProcessDefinitionInfo, String> {

}

