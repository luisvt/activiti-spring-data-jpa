package org.activiti.springdatajpa.models;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Property generated by hbm2java
 */
@Entity
@Table(name = "act_ge_property")
public class Property implements java.io.Serializable {

    private String name;
    private String value;
    private Integer rev;

    public Property() {
    }

    public Property(String name) {
        this.name = name;
    }

    public Property(String name, String value, Integer rev) {
        this.name = name;
        this.value = value;
        this.rev = rev;
    }

    @Id
    @Column(name = "name_", unique = true, nullable = false, length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "value_", length = 300)
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "rev_")
    public Integer getRev() {
        return this.rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }
}

