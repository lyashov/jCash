package com.diagnoses.repository;


import com.diagnoses.model.DiagnosesEmptity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosesRepository
        extends JpaRepository<DiagnosesEmptity, Long> {

}
