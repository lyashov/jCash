package com.diagnoses.model;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="VISITS")
public class VisitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_pacient")
    private Long id_pacient;

    @Column(name="id_doctor")
    private Long id_doctor;

    @Column(name="date_visit")
    private Date date_visit;

    @Column(name="id_diagnosis")
    private Long id_diagnosis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(Long id_pacient) {
        this.id_pacient = id_pacient;
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Date getDate_visit() {
        return date_visit;
    }

    public void setDate_visit(Date date_visit) {
        this.date_visit = date_visit;
    }

    public Long getId_diagnosis() {
        return id_diagnosis;
    }

    public void setId_diagnosis(Long id_diagnosis) {
        this.id_diagnosis = id_diagnosis;
    }
}