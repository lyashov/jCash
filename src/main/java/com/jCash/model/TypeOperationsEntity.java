package com.jCash.model;


import javax.persistence.*;

@Entity
@Table(name="TYPE_OPERATIONS")
public class TypeOperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="debitcredit", nullable=false)
    private Integer debitcredit;

    @Column(name="operation", nullable=false, length=200)
    private String operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDebitcredit() {
        return debitcredit;
    }

    public void setDebitcredit(Integer debitcredit) {
        this.debitcredit = debitcredit;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return getOperation();
    }
}