package org.activiti.springdatajpa.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "act_hi_comment")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator)
public class Comment {

    public Comment() {
    }

    public Comment(String id, Date time) {
        this.id = id;
        this.time = time;
    }

    public Comment(String id, String type, Date time, String userId, String taskId, String procInstId, String action, String message, byte[] fullMsg) {
        this.id = id;
        this.type = type;
        this.time = time;
        this.userId = userId;
        this.taskId = taskId;
        this.procInstId = procInstId;
        this.action = action;
        this.message = message;
        this.fullMsg = fullMsg;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @Column(name = "type_")
    String type

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_", nullable = false, length = 29)
    Date time

    @Column(name = "user_id_")
    String userId

    @Column(name = "task_id_", length = 64)
    String taskId

    @Column(name = "proc_inst_id_", length = 64)
    String procInstId

    @Column(name = "action_")
    String action

    @Column(name = "message_", length = 4000)
    String message

    @Column(name = "full_msg_")
    public byte[] getFullMsg() {
        return this.fullMsg;
    }

    public void setFullMsg(byte[] fullMsg) {
        this.fullMsg = fullMsg;
    }
}


