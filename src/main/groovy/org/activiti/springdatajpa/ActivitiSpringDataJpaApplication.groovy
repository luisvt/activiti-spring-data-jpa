package org.activiti.springdatajpa

import org.activiti.engine.ProcessEngine
import org.activiti.springdatajpa.models.Property
import org.activiti.springdatajpa.repositories.PropertyRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ActivitiSpringDataJpaApplication{

    static void main(String[] args) {
        SpringApplication.run ActivitiSpringDataJpaApplication, args
    }

    @Bean
    InitializingBean initializingBean(final PropertyRepository propertyRepository) {
        new InitializingBean() {
            @Override
            void afterPropertiesSet() throws Exception {
                propertyRepository.save(new Property('schema.version', ProcessEngine.VERSION, 0))
            }
        }
    }
}
