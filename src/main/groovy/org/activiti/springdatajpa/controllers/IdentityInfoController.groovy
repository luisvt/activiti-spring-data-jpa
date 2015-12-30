package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.IdentityInfoRepository
import org.activiti.springdatajpa.models.IdentityInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/identity-infos')
class IdentityInfoController extends AbstractRestController<IdentityInfoRepository, IdentityInfo, String> {

}

