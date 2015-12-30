package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Deployment
import org.activiti.springdatajpa.repositories.DeploymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/deployments')
class DeploymentController extends AbstractRestController<DeploymentRepository, Deployment, String> {

}

