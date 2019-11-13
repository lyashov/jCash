package com.diagnoses.repository;


import com.diagnoses.model.PacientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientsRepository
        extends JpaRepository<PacientsEntity, Long> {

}
