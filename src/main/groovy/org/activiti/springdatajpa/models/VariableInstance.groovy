package org.activiti.springdatajpa.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;

/**
 * VariableInstance generated by hbm2java
 */
@Entity
@Table(name = "act_ru_variable")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator)
public class VariableInstance {

    public VariableInstance() {
    }

    public VariableInstance(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public VariableInstance(String id, Execution execution, ByteArray byteArray, Execution processInstance, Integer rev, String type, String name, String taskId, Double double_, Long long_, String text, String text2) {
        this.id = id;
        this.execution = execution;
        this.byteArray = byteArray;
        this.processInstance = processInstance;
        this.rev = rev;
        this.type = type;
        this.name = name;
        this.taskId = taskId;
        this.double_ = double_;
        this.long_ = long_;
        this.text = text;
        this.text2 = text2;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "execution_id_")
    Execution execution

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bytearray_id_")
    ByteArray byteArray

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proc_inst_id_")
    Execution processInstance

    @Column(name = "rev_")
    Integer rev

    @Column(name = "type_", nullable = false)
    String type

    @Column(name = "name_", nullable = false)
    String name

    @Column(name = "task_id_", length = 64)
    String taskId

    @Column(name = "double_", precision = 17, scale = 17)
    Double double_

    @Column(name = "long_")
    Long long_

    @Column(name = "text_", length = 4000)
    String text

    @Column(name = "text2_", length = 4000)
    String text2
}


