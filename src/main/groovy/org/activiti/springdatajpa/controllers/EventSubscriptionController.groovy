package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.EventSubscription
import org.activiti.springdatajpa.repositories.EventSubscriptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/event-subscriptions')
class EventSubscriptionController extends AbstractRestController<EventSubscriptionRepository, EventSubscription, String> {

}

