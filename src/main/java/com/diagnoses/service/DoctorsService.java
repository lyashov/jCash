package com.diagnoses.service;

import com.diagnoses.exception.RecordNotFoundException;
import com.diagnoses.model.DoctorsEntity;
import com.diagnoses.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {
     
    @Autowired
    DoctorsRepository repository;


   /* EntityManager entityManager;
    public Long getMaxEmpId() {
        try {

            String sql = "SELECT coalesce(max(e.id), 0) FROM Employee e";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        } catch (NoResultException e) {
            return 0L;
        }
    }*/

    public List<DoctorsEntity> getAllDoctors()
    {
        List<DoctorsEntity> doctorsList = repository.findAll();

        if(doctorsList.size() > 0) {
            return doctorsList;
        } else {
            return new ArrayList<DoctorsEntity>();
        }
    }

    public DoctorsEntity getDoctorById(Long id) throws RecordNotFoundException
    {
        Optional<DoctorsEntity> doctor = repository.findById(id);

        if(doctor.isPresent()) {
            return doctor.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }

    public DoctorsEntity createOrUpdateDocor(DoctorsEntity entity) throws RecordNotFoundException
    {
        Optional<DoctorsEntity> doctor = repository.findById(entity.getId());

        if(doctor.isPresent())
        {
            DoctorsEntity newEntity = doctor.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setSecondName(entity.getLastName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setLogin(entity.getLastName());
            newEntity.setPassword(entity.getEmail());
            newEntity.setEmail(entity.getEmail());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteDocdorById(Long id) throws RecordNotFoundException
    {
        Optional<DoctorsEntity> doctor = repository.findById(id);
         
        if(doctor.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }
}