package com.jCash.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="OPERATIONS")
public class OperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_operation", nullable=false)
    private Date data_operation;

    @ManyToOne (optional=false, fetch = FetchType.EAGER)
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

    public String getDebit_credit() {
        return (debit_credit == 0) ? "Приход" : "Расход";
    }

    public String getCard_cash() {
        return (card_cash == 0) ? "Наличными" : "Картой";
    }
}