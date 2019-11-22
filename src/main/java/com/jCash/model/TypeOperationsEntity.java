package com.jCash.model;


import lombok.Data;

import javax.persistence.*;
@Data
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

    @Override
    public String toString() {
        return operation;
    }
}