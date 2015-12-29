package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "act_id_group")
public class Group implements java.io.Serializable {

    private String id;
    private Integer rev;
    private String name;
    private String type;
    private Set<User> users = new HashSet<User>(0);

    public Group() {
    }

    public Group(String id) {
        this.id = id;
    }

    public Group(String id, Integer rev, String name, String type, Set<User> users) {
        this.id = id;
        this.rev = rev;
        this.name = name;
        this.type = type;
        this.users = users;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "rev_")
    public Integer getRev() {
        return this.rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    @Column(name = "name_")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type_")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "act_id_membership", schema = "public", joinColumns = {
            @JoinColumn(name = "group_id_", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "user_id_", nullable = false, updatable = false)})
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}


