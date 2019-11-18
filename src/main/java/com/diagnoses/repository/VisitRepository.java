package com.diagnoses.repository;

import com.diagnoses.model.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository
        extends JpaRepository<VisitsEntity, Long> {

}
