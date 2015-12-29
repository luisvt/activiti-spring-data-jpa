package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IdentityInfo generated by hbm2java
 */
@Entity
@Table(name = "act_id_info")
public class IdentityInfo {










    public IdentityInfo() {
    }

    public IdentityInfo(String id) {
        this.id = id;
    }

    public IdentityInfo(String id, Integer rev, String userId, String type, String key, String value, byte[] password, String parentId) {
        this.id = id;
        this.rev = rev;
        this.userId = userId;
        this.type = type;
        this.key = key;
        this.value = value;
        this.password = password;
        this.parentId = parentId;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String id

    @Column(name = "rev_")
    Integer rev

    @Column(name = "user_id_", length = 64)
    String userId

    @Column(name = "type_", length = 64)
    String type

    @Column(name = "key_")
    String key

    @Column(name = "value_")
    String value

    @Column(name = "password_")
    public byte[] getPassword() {
        return this.password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Column(name = "parent_id_")
    String parentId
}


