package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.models.IdentityLink
import org.activiti.springdatajpa.repositories.IdentityLinkRepository
import org.activiti.springdatajpa.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/identity-links')
class IdentityLinkController extends AbstractRestController<IdentityLink, String> {

    @Autowired
    IdentityLinkController(IdentityLinkRepository repo) {
        super(repo)
    }
}

