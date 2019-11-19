package com.diagnoses.model;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="OPERATIONS")
public class OperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="debit_credit", nullable=false)
    private Integer debit_credit;

    @Column(name="id_user", nullable=false)
    private Long id_user;

    @Column(name="id_type_operation", nullable=false)
    private Long id_type_operation;

    @Column(name="card_cash ", nullable=false)
    private Long card_cash;

    @Column(name="sum", nullable=false)
    private Double sum;

    @Column(name="comment", nullable=false, length=200)
    private String comment;

   // @JoinColumn(name = "id_pacient", referencedColumnName = "id")
//    @OneToMany
//    private Set<VisitsEntity> visits;
//
//    public String getVisits() {
//        return visits.toArray().toString();
//    }
//
//    public void setVisits(Set<VisitsEntity> visits) {
//        this.visits = visits;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDebit_credit() {
        return debit_credit;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public void setDebit_credit(Integer debit_credit) {
        this.debit_credit = debit_credit;
    }

    public Long getId_type_operation() {
        return id_type_operation;
    }

    public void setId_type_operation(Long id_type_operation) {
        this.id_type_operation = id_type_operation;
    }

    public Long getCard_cash() {
        return card_cash;
    }

    public void setCard_cash(Long card_cash) {
        this.card_cash = card_cash;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}