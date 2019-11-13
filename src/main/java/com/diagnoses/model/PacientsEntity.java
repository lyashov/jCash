package com.diagnoses.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="PACIENTS")
public class PacientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   // @JoinColumn(name = "id_pacient", referencedColumnName = "id")
    @OneToMany
    private Set<VisitsEntity> visits;

    public String getVisits() {
        return visits.toArray().toString();
    }

    public void setVisits(Set<VisitsEntity> visits) {
        this.visits = visits;
    }

    @Column(name="first_name", nullable=false, length=200)
    private String firstName;

    @Column(name="second_name", nullable=false, length=200)
    private String secondName;

    @Column(name="last_name", nullable=false, length=200)
    private String lastName;

    @Column(name="login", nullable=false, length=150)
    private String login;

    @Column(name="password", nullable=false, length=100)
    private String password;

    @Column(name="email", nullable=false, length=100)
    private String email;

    @Column(name="sex")
    private Boolean sex;

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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "PacientsEntity [id=" + id + ", firstName=" + firstName +
                ", secondName=" + secondName + ", lastName=" + lastName +
                ", email=" + email + (sex ? 'м':'ж')  +
                ", login=" + login + "]";
    }
}