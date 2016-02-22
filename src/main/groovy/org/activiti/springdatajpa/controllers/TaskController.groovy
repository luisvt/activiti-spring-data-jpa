package org.activiti.springdatajpa.controllers

import org.activiti.engine.RuntimeService
import org.activiti.engine.TaskService
import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.NotAllowedException
import org.activiti.springdatajpa.NotValidProcessVariables
import org.activiti.springdatajpa.models.Task
import org.activiti.springdatajpa.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.*

import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Validator

import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping('/tasks')
class TaskController extends AbstractRestController<TaskRepository, Task, String> {

    @Autowired
    TaskService taskService

    @Autowired
    RuntimeService runtimeService

    @Autowired
    EntityManager em

    @Autowired
    Validator validator

    @Override
    Iterable<Task> findAll(@RequestParam(required = false) Integer page,
                           @RequestParam(required = false) Integer size,
                           @AuthenticationPrincipal User user) {
        if(user.authorities.any {it.authority == 'admin'})
            return repo.findAll(new PageRequest(page, size))

        repo.findAllByIdentityLinks_GroupId(user.authorities[0].authority)
    }

    @Transactional
    @RequestMapping(path = '/{id}/start', method = POST)
    Task start(@PathVariable String id,
               @AuthenticationPrincipal User user
    ) throws NotAllowedException  {
        def task = repo.findOne(id)
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        taskService.delegateTask(id, user.username)


        em.refresh(task)

        task.processVariables = taskService.createTaskQuery()
                .taskId(id)
                .includeProcessVariables()
                .singleResult()
                .processVariables

        task
    }

    @Transactional
    @RequestMapping(path = '/{id}/pause', method = POST)
    Task pause(@PathVariable String id,
               @AuthenticationPrincipal User user
    ) throws NotAllowedException  {
        def task = repo.findOne(id)
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        taskService.delegateTask(id, null)

        em.refresh(task)

        task.delegationState = null

        repo.save(task)

        task.processVariables = taskService.createTaskQuery()
                .taskId(id)
                .includeProcessVariables()
                .singleResult()
                .processVariables

        task
    }

    @Transactional
    @RequestMapping(path = '/{id}/resolve', method = POST)
    Task resolve(@PathVariable String id,
                 @AuthenticationPrincipal User user,
                 @RequestBody(required = false) Map<String, Object> variables
    ) throws NotAllowedException {
        def task = repo.findOne(id);
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        variables.each {key, value ->
            def violations = validator.validate(value)
            if(!violations.isEmpty())
                //TODO: enhance response message which should contains violations
                throw new NotValidProcessVariables()

            em.merge(value)
        }

        taskService.resolveTask(id, variables)

        em.refresh(task)
        task
    }


    @Transactional
    @RequestMapping(path = '/{id}/complete', method = POST)
    Task complete(@PathVariable String id,
                  @AuthenticationPrincipal User user,
                  @RequestBody(required = false) Map<String, Object> variables
    ) throws NotAllowedException {
        def task = repo.findOne(id);
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        variables.each {key, value ->
            def violations = validator.validate(value)
            if(!violations.isEmpty())
            //TODO: enhance response message which should contains violations
                throw new NotValidProcessVariables()

            em.merge(value)
        }

        taskService.complete(id, variables)
        em.refresh(task)
        task
    }

    @Transactional
    @RequestMapping('/{id}/claim')
    Task claim(@PathVariable String id,
               @AuthenticationPrincipal User user
    ) throws NotAllowedException {
        def task = repo.findOne(id);
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        taskService.claim(id, user.username)
        em.refresh(task)
        task
    }


    @Transactional
    @RequestMapping('/{id}/un-claim')
    Task unClaim(@PathVariable String id,
                 @AuthenticationPrincipal User user
    ) throws NotAllowedException {
        def task = repo.findOne(id);
        if(!task.isCandidate(new org.activiti.springdatajpa.models.User(user)))
            throw new NotAllowedException()

        taskService.unclaim(id)
        em.refresh(task)
        task
    }
}
