package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;

/**
 * HistoricProcessInstance generated by hbm2java
 */
@Entity
@Table(name = "act_hi_procinst"
        , uniqueConstraints = @UniqueConstraint(columnNames = "proc_inst_id_")
)
public class HistoricProcessInstance {

    public HistoricProcessInstance() {
    }

    public HistoricProcessInstance(String id, String processInstanceId, String processDefinitionId, Date startTime) {
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.processDefinitionId = processDefinitionId;
        this.startTime = startTime;
    }

    public HistoricProcessInstance(String id, String processInstanceId, String businessKey, String processDefinitionId, Date startTime, Date endTime, Long duration, String startUserId, String startActId, String endActId, String superProcessInstanceId, String deleteReason, String tenantId, String name) {
        this.id = id;
        this.processInstanceId = processInstanceId;
        this.businessKey = businessKey;
        this.processDefinitionId = processDefinitionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.startUserId = startUserId;
        this.startActId = startActId;
        this.endActId = endActId;
        this.superProcessInstanceId = superProcessInstanceId;
        this.deleteReason = deleteReason;
        this.tenantId = tenantId;
        this.name = name;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @Column(name = "proc_inst_id_", unique = true, nullable = false, length = 64)
    String processInstanceId

    @Column(name = "business_key_")
    String businessKey

    @Column(name = "proc_def_id_", nullable = false, length = 64)
    String processDefinitionId

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time_", nullable = false, length = 29)
    Date startTime

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time_", length = 29)
    Date endTime

    @Column(name = "duration_")
    Long duration

    @Column(name = "start_user_id_")
    String startUserId

    @Column(name = "start_act_id_")
    String startActId

    @Column(name = "end_act_id_")
    String endActId

    @Column(name = "super_process_instance_id_", length = 64)
    String superProcessInstanceId

    @Column(name = "delete_reason_", length = 4000)
    String deleteReason

    @Column(name = "tenant_id_")
    String tenantId

    @Column(name = "name_")
    String name
}


