package org.activiti.springdatajpa.models

import org.hibernate.validator.constraints.NotBlank
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails;
// Generated Nov 21, 2015 11:41:58 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.*

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "act_id_user")
public class User implements UserDetails {

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, Integer rev, String first, String last, String email, String password, String pictureId, Set<Group> authorities) {
        this.username = username;
        this.rev = rev;
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
        this.pictureId = pictureId;
        this.authorities = authorities;
    }

    @Id
    @Column(name = "id_", unique = true, nullable = false, length = 64)
    String username

    @Column(name = "rev_")
    Integer rev

    @Column(name = "first_")
    String first

    @Column(name = "last_")
    String last

    @Column(name = "email_")
    String email

    @Column(name = "pwd_")
    @NotBlank
    String password

    @Column(name = "picture_id_", length = 64)
    String pictureId

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "act_id_membership", schema = "public",
            joinColumns = [@JoinColumn(name = "user_id_", nullable = false, updatable = false)],
            inverseJoinColumns = [@JoinColumn(name = "group_id_", nullable = false, updatable = false)])
    Set<Group> authorities

    boolean accountNonExpired

    boolean accountNonLocked

    boolean credentialsNonExpired

    boolean enabled
}


