package com.jCash.model;


import javax.persistence.*;

@Entity
@Table(name="TYPE_OPERATIONS")
public class TypeOperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="debit_credit", nullable=false)
    private Integer debit_credit;

    @Column(name="operation", nullable=false, length=200)
    private String operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDebit_credit() {
        return debit_credit;
    }

    public void setDebit_credit(Integer debit_credit) {
        this.debit_credit = debit_credit;
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