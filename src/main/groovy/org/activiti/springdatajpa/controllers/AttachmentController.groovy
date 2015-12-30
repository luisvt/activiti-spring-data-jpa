package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Attachment
import org.activiti.springdatajpa.repositories.AttachmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/attachments')
class AttachmentController extends AbstractRestController<AttachmentRepository, Attachment, String> {

}

