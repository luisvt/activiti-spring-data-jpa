package org.activiti.springdatajpa.repositories

import org.activiti.springdatajpa.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UserRepository extends JpaRepository<User, String> {

    User findOneByUsername(String username)
}

