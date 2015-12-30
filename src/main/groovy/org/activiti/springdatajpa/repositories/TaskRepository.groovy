package org.activiti.springdatajpa.repositories

import org.activiti.springdatajpa.models.Task
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository extends JpaRepository<Task, String> {

    Task findOneByParentTaskId(String parentTaskId)

    Task findOneByExecutionId(String executionId)

    Task findOneByProcessInstanceId(String processInstanceId)

    List<Task> findAllByIdentityLinks_GroupId(String identityLinkGroupId)

}

