package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.models.Comment
import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.repositories.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/comments')
class CommentController extends AbstractRestController<Comment, String> {

    @Autowired
    CommentController(CommentRepository repo) {
        super(repo)
    }
}

