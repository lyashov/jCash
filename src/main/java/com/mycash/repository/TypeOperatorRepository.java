package com.mycash.repository;

import com.mycash.model.TypeOperationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface TypeOperatorRepository
            extends JpaRepository<TypeOperationsEntity, Long> {
    }
