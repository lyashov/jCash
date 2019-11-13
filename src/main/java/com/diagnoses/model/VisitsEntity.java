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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pacient", nullable = false)
    private PacientsEntity pacient;

    @Column(name="id_doctor")
    private Long id_doctor;

    @Column(name="date_visit")
    private Date date_visit;

    @Column(name="id_diagnosis")
    private Long id_diagnosis;

    public PacientsEntity getPacient() {
        return pacient;
    }

    public void setPacient(PacientsEntity pacient) {
        this.pacient = pacient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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