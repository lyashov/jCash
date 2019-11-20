package com.jCash.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="OPERATIONS")
public class OperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_operation", nullable=false)
    private Date data_operation;

    @ManyToOne (optional=false)
    @JoinColumn (name="id_user",referencedColumnName="id")
    private UsersEntity user;

    @Column(name="debit_credit", nullable=false)
    private Integer debit_credit;

    @ManyToOne (optional=false)
    @JoinColumn (name="id_type_operation",referencedColumnName="id")
    private TypeOperationsEntity typeOperation;

    @Column(name="card_cash ", nullable=false)
    private Long card_cash;

    @Column(name="sum", nullable=false)
    private Double sum;

    @Column(name="comment", nullable=false, length=200)
    private String comment;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_operation() {
        return data_operation;
    }

    public void setData_operation(Date data_operation) {
        this.data_operation = data_operation;
    }

    public String getDebit_credit() {
        return (debit_credit == 0) ? "Приход" : "Расход";
    }

    public void setDebit_credit(Integer debit_credit) {
        this.debit_credit = debit_credit;
    }

    public TypeOperationsEntity getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperationsEntity typeOperation) {
        this.typeOperation = typeOperation;
    }

    public String getCard_cash() {
        return (card_cash == 0) ? "Наличными" : "Картой";
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