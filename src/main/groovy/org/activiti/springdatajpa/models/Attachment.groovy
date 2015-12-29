package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;

/**
 * Attachment generated by hbm2java
 */
@Entity
@Table(name = "act_hi_attachment")
public class Attachment {

    public Attachment() {
    }

    public Attachment(String id) {
        this.id = id;
    }

    public Attachment(String id, Integer rev, String userId, String name, String description, String type, String taskId, String procInstId, String url, String contentId, Date time) {
        this.id = id;
        this.rev = rev;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.taskId = taskId;
        this.procInstId = procInstId;
        this.url = url;
        this.contentId = contentId;
        this.time = time;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @Column(name = "rev_")
    Integer rev

    @Column(name = "user_id_")
    String userId

    @Column(name = "name_")
    String name

    @Column(name = "description_", length = 4000)
    String description

    @Column(name = "type_")
    String type

    @Column(name = "task_id_", length = 64)
    String taskId

    @Column(name = "proc_inst_id_", length = 64)
    String procInstId

    @Column(name = "url_", length = 4000)
    String url

    @Column(name = "content_id_", length = 64)
    String contentId

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_", length = 29)
    Date time
}

