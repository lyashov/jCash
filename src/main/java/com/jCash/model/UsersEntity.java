package com.jCash.model;


import javax.persistence.*;

@Entity
@Table(name="USR")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username", nullable=false, length=200)
    private String username;

   // @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
   // @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  //  @Enumerated(EnumType.STRING)
  //  private Set<Role> roles;

    @Column(name="active", nullable=false)
    private Boolean active;

    @Column(name="login", nullable=true, length=150)
    private String login;

    @Column(name="password", nullable=true, length=100)
    private String password;

    @Column(name="email", nullable=false, length=100)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return username + " (" + login + ")";
    }
}