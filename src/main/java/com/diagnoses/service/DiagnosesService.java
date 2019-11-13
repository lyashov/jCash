package com.diagnoses.service;

import com.diagnoses.exception.RecordNotFoundException;
import com.diagnoses.model.DiagnosesEmptity;
import com.diagnoses.model.PacientsEntity;
import com.diagnoses.repository.DiagnosesRepository;
import com.diagnoses.repository.PacientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosesService {
     
    @Autowired
    DiagnosesRepository repository;


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

    public List<DiagnosesEmptity> getAllDiagnoses()
    {
        List<DiagnosesEmptity> diagnosesList = repository.findAll();

        if(diagnosesList.size() > 0) {
            return diagnosesList;
        } else {
            return new ArrayList<DiagnosesEmptity>();
        }
    }

    public DiagnosesEmptity getDiagnoseById(Long id) throws RecordNotFoundException
    {
        Optional<DiagnosesEmptity> diagnose = repository.findById(id);

        if(diagnose.isPresent()) {
            return diagnose.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }

 /*  public DiagnosesEmptity\ createOrUpdateDocor(DiagnosesRepository entity) throws RecordNotFoundException
    {
        Optional<DiagnosesEmptity> diagnose = repository.findById(entity.getId());

        if(pacient.isPresent())
        {
            PacientsEntity newEntity = pacient.get();
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
        Optional<PacientsEntity> pacient = repository.findById(id);
         
        if(pacient.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }*/
}