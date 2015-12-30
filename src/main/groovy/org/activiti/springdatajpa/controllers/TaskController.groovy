package org.activiti.springdatajpa.controllers

import org.activiti.engine.TaskService
import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.Task
import org.activiti.springdatajpa.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/tasks')
class TaskController extends AbstractRestController<TaskRepository, Task, String> {

    @Autowired
    TaskService taskService

    @Override
    Iterable<Task> findAll(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) Integer size,
                           @AuthenticationPrincipal User user) {
        if(user.authorities.any {it.authority == 'admin'})
            return repo.findAll(new PageRequest(page, size))

        repo.findAllByIdentityLinks_GroupId(user.authorities[0].authority)
    }

    @RequestMapping('/{id}/start')
    Task start(@PathVariable String id, @AuthenticationPrincipal User user) {
        taskService.delegateTask(id, user.username)
        repo.findOne(id);
    }

    @RequestMapping('/{id}/resolve')
    Task resolve(@PathVariable String id,
                 @AuthenticationPrincipal User user,
                 @RequestBody(required = false) Map<String, Object> variables
    ) {
        taskService.resolveTask(id, variables)
        repo.findOne(id);
    }


    @RequestMapping('/{id}/complete')
    Task complete(@PathVariable String id,
                  @AuthenticationPrincipal User user,
                  @RequestBody(required = false) Map<String, Object> variables) {
        taskService.complete(id, variables)
        repo.findOne(id);
    }

    @RequestMapping('/{id}/claim')
    Task claim(@PathVariable String id, @AuthenticationPrincipal User user) {
        taskService.claim(id, user.username)
        repo.findOne(id)
    }


    @RequestMapping('/{id}/un-claim')
    Task unClaim(@PathVariable String id, @AuthenticationPrincipal User user) {
        taskService.unclaim(id)
        repo.findOne(id)
    }
}

