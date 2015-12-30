package org.activiti.springdatajpa.repositories

import org.activiti.engine.IdentityService
import org.activiti.engine.RepositoryService
import org.activiti.engine.RuntimeService
import org.activiti.engine.TaskService;
import org.activiti.springdatajpa.ActivitiSpringDataJpaApplication
import org.activiti.springdatajpa.models.Group
import org.activiti.springdatajpa.models.User;
import org.junit.Test;
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = ActivitiSpringDataJpaApplication)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository

    @Test
    @Transactional
    void addUser() {
        userRepository.save(new User(
                rev: 1,
                first: 'userFirt1',
                last: 'userLast1',
                email: 'userEmail1',
                password: 'user1',
                username: 'user1',
                authorities: [new Group(
                        id: '1',
                        rev: 1,
                        name: 'group1',
                        type: 'groupType1'
                )]
        ))

        def user1 = userRepository.findOne('user1')

        assertEquals('user1', user1.username);
        assertEquals('group1', user1.authorities[0].name)
    }
}