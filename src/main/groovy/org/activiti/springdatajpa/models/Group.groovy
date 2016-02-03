package org.activiti.springdatajpa.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.security.core.GrantedAuthority

import javax.persistence.*;

// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA
/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "act_id_group")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator)
public class Group implements GrantedAuthority {

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
    String id

    @Column(name = "rev_")
    Integer rev

    @Column(name = "name_")
    String name

    @Column(name = "type_")
    String type

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "act_id_membership", schema = "public",
            joinColumns = [@JoinColumn(name = "group_id_", nullable = false, updatable = false)],
            inverseJoinColumns = [@JoinColumn(name = "user_id_", nullable = false, updatable = false)])
    Set<User> users

    @Override
    @Transient
    @JsonIgnore
    String getAuthority() {
        name
    }
}


