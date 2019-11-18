package com.diagnoses.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="VISITS")
public class VisitsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PacientsEntity [i";
    }
}