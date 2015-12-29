package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Task
import org.activiti.springdatajpa.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/tasks')
class TaskController extends AbstractRestController<Task, String> {

    TaskRepository repo

    @Autowired
    TaskController(TaskRepository repo) {
        super(repo)
        this.repo = repo
    }
}

