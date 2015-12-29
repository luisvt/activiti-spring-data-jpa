package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;

/**
 * EventSubscription generated by hbm2java
 */
@Entity
@Table(name = "act_ru_event_subscr")
public class EventSubscription {

    public EventSubscription() {
    }

    public EventSubscription(String id, String eventType, Date created) {
        this.id = id;
        this.eventType = eventType;
        this.created = created;
    }

    public EventSubscription(String id, Execution execution, Integer rev, String eventType, String eventName, String procInstId, String activityId, String configuration, Date created, String procDefId, String tenantId) {
        this.id = id;
        this.execution = execution;
        this.rev = rev;
        this.eventType = eventType;
        this.eventName = eventName;
        this.procInstId = procInstId;
        this.activityId = activityId;
        this.configuration = configuration;
        this.created = created;
        this.procDefId = procDefId;
        this.tenantId = tenantId;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execution_id_")
    Execution execution

    @Column(name = "rev_")
    Integer rev

    @Column(name = "event_type_", nullable = false)
    String eventType

    @Column(name = "event_name_")
    String eventName

    @Column(name = "proc_inst_id_", length = 64)
    String procInstId

    @Column(name = "activity_id_", length = 64)
    String activityId

    @Column(name = "configuration_")
    String configuration

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_", nullable = false, length = 29)
    Date created

    @Column(name = "proc_def_id_", length = 64)
    String procDefId

    @Column(name = "tenant_id_")
    String tenantId
}


