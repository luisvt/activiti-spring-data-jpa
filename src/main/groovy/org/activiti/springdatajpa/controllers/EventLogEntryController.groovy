package org.activiti.springdatajpa.controllers

import org.activiti.springdatajpa.AbstractRestController
import org.activiti.springdatajpa.models.EventLogEntry
import org.activiti.springdatajpa.repositories.EventLogEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/event-log-entries')
class EventLogEntryController extends AbstractRestController<EventLogEntryRepository, EventLogEntry, String> {

}

