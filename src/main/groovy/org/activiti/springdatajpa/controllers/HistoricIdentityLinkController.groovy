package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.HistoricIdentityLink
import org.activiti.springdatajpa.repositories.HistoricIdentityLinkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/historic-identity-links')
class HistoricIdentityLinkController extends AbstractRestController<HistoricIdentityLinkRepository, HistoricIdentityLink, String> {

}

