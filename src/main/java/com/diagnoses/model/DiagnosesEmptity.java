package com.diagnoses.model;
import javax.persistence.*;

@Entity
@Table(name="DIAGNOSES")
public class DiagnosesEmptity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="short_description", nullable=false, length=250)
    private String short_description;

    @Column(name="description", nullable=false, length=250)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}