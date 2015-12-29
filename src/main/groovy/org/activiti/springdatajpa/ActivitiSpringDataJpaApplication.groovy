package org.activiti.springdatajpa

import org.activiti.engine.ProcessEngine
import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration
import org.activiti.springdatajpa.models.Property
import org.activiti.springdatajpa.repositories.PropertyRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order

@SpringBootApplication
class ActivitiSpringDataJpaApplication{

    static void main(String[] args) {
        SpringApplication.run ActivitiSpringDataJpaApplication, args
    }
}
