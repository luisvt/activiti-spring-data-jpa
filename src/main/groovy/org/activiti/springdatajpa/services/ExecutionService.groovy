package org.activiti.springdatajpa.services

import org.activiti.springdatajpa.models.IdentityLink
import org.activiti.springdatajpa.models.enums.IdentityLinkType
import org.activiti.springdatajpa.repositories.ExecutionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by luis on 12/29/15.
 */
@Service
class ExecutionService {
    @Autowired
    ExecutionRepository repo

//    /**
//     * Adds an IdentityLink for this user with the specified type,
//     * but only if the user is not associated with this instance yet.
//     **/
//    public IdentityLink involveUser(String userId, IdentityLinkType type) {
//        repo.findOne().identityLinks.find { it.isUser() && it.userId == userId } ?: addIdentityLink(userId, null, type)
//    }
//
//
//    public IdentityLink addIdentityLink(String userId, String groupId, IdentityLinkType type) {
//        IdentityLink identityLink = new IdentityLink(this, groupId, type, userId);
//        identityLinks.add(identityLink);
//        identityLink.setProcessInstance(this);
//        identityLink.setUserId(userId);
//        identityLink.setGroupId(groupId);
//        identityLink.setType(type);
//        identityLink.insert();
//        identityLink;
//    }
}
