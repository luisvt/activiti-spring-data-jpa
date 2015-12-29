package org.activiti.springdatajpa.repositories

import org.activiti.springdatajpa.models.IdentityLink
import org.activiti.springdatajpa.models.enums.IdentityLinkType
import org.springframework.data.jpa.repository.JpaRepository

interface IdentityLinkRepository extends JpaRepository<IdentityLink, String> {

    List<IdentityLink> findByTaskIdAndUserIdAndGroupIdAndType(String taskId, String userId, String groupId, IdentityLinkType type)
}

