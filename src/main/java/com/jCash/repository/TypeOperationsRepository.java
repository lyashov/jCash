package com.jCash.repository;


import com.jCash.model.OperationsEntity;
import com.jCash.model.TypeOperationsEntity;
import com.jCash.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOperationsRepository
        extends JpaRepository<TypeOperationsEntity, Long> {
    List<TypeOperationsEntity> getAllByDebitcredit(Integer debitCredit);

}
