package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;

/**
 * ProcessDefinitionInfo generated by hbm2java
 */
@Entity
@Table(name = "act_procdef_info",
        uniqueConstraints = @UniqueConstraint(columnNames = "proc_def_id_")
)
public class ProcessDefinitionInfo implements java.io.Serializable {

    private String id;
    private ProcessDefinition processDefinition;
    private ByteArray byteArray;
    private Integer rev;

    public ProcessDefinitionInfo() {
    }

    public ProcessDefinitionInfo(String id, ProcessDefinition processDefinition) {
        this.id = id;
        this.processDefinition = processDefinition;
    }

    public ProcessDefinitionInfo(String id, ProcessDefinition processDefinition, ByteArray byteArray, Integer rev) {
        this.id = id;
        this.processDefinition = processDefinition;
        this.byteArray = byteArray;
        this.rev = rev;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proc_def_id_", unique = true, nullable = false)
    public ProcessDefinition getProcessDefinition() {
        return this.processDefinition;
    }

    public void setProcessDefinition(ProcessDefinition processDefinition) {
        this.processDefinition = processDefinition;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_json_id_")
    public ByteArray getByteArray() {
        return this.byteArray;
    }

    public void setByteArray(ByteArray byteArray) {
        this.byteArray = byteArray;
    }

    @Column(name = "rev_")
    public Integer getRev() {
        return this.rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }
}


