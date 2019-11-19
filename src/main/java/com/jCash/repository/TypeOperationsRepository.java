package com.jCash.repository;


import com.jCash.model.TypeOperationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationsRepository
        extends JpaRepository<TypeOperationsEntity, Long> {

}
