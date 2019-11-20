package com.jCash.model;


import com.jCash.configs.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="USR")
public class UsersEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username", nullable=false, length=200)
    private String username;

    @Column(name="login", nullable=true, length=150)
    private String login;

    @Column(name="password", nullable=true, length=100)
    private String password;

    @Column(name="email", nullable=false, length=100)
    private String email;

    @Column(name="active", nullable=false)
    private Boolean active;

    @Transient
    public List<Role> authorities;
    @Transient
    public boolean accountNonExpired;
    @Transient
    public boolean accountNonLocked;
    @Transient
    public boolean credentialsNonExpired;
    @Transient
    public boolean enabled;

    @Override
    public String toString() {
        return getUsername();
    }
}