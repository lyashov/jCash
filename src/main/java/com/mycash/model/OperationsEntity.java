package com.mycash.model;


import javax.persistence.*;

@Entity
@Table(name="TBL_OPERATIONS")
public class OperationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private int userId;

    @Column(name="sum")
    private int sum;

    @Column(name="type_operation_id")
    private int typeOperationId;

    @Column(name="operation")
    private int operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(int typeOperationId) {
        this.typeOperationId = typeOperationId;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
//@Column(name="email", nullable=false, length=200)
    //private String email;

    //@Column(name="password", nullable=false, length=45)
    //private String password;

}