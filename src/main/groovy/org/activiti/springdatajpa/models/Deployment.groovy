package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Deployment generated by hbm2java
 */
@Entity
@Table(name = "act_re_deployment")
public class Deployment {

    public Deployment() {
    }

    public Deployment(String id) {
        this.id = id;
    }

    public Deployment(String id, String name, String category, String tenantId, Date deployTime, Set<Model> models, Set<ByteArray> actGeBytearraies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.tenantId = tenantId;
        this.deployTime = deployTime;
        this.models = models;
        this.actGeBytearraies = actGeBytearraies;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @Column(name = "name_")
    String name

    @Column(name = "category_")
    String category

    @Column(name = "tenant_id_")
    String tenantId

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deploy_time_", length = 29)
    Date deployTime

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deployment")
    Set<Model> models

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deployment")
    Set<ByteArray> actGeBytearraies
}


