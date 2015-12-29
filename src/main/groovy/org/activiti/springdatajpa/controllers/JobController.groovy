package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Job
import org.activiti.springdatajpa.repositories.JobRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/jobs')
class JobController extends AbstractRestController<Job, String> {

    @Autowired
    JobController(JobRepository repo) {
        super(repo)
    }
}

