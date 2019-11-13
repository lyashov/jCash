package com.diagnoses.repository;


import com.diagnoses.model.DoctorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository
        extends JpaRepository<DoctorsEntity, Long> {

}
