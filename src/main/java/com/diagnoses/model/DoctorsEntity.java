package com.diagnoses.model;


import javax.persistence.*;

@Entity
@Table(name="DOCTORS")
public class DoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable=false, length=200)
    private String firstName;

    @Column(name="second_name", nullable=false, length=200)
    private String secondName;

    @Column(name="last_name", nullable=false, length=200)
    private String lastName;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "DoctorsEntity [id=" + id + ", firstName=" + firstName +
                ", secondName=" + secondName + ", lastName=" + lastName +
                ", email=" + email + ", login= " + "]";
    }
}