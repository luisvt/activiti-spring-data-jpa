package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.GroupRepository
import org.activiti.springdatajpa.models.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/groups')
class GroupController extends AbstractRestController<GroupRepository, Group, String> {

}

