package com.jCash.service;

import com.jCash.exception.RecordNotFoundException;
import com.jCash.model.OperationsEntity;
import com.jCash.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationsService {
     
    @Autowired
    OperationsRepository repository;


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

    public List<OperationsEntity> getAllOperations()
    {
        List<OperationsEntity> OperationsList = repository.findAll();

        if(OperationsList.size() > 0) {
            return OperationsList;
        } else {
            return new ArrayList<OperationsEntity>();
        }
    }

    public OperationsEntity getDiagnoseById(Long id) throws RecordNotFoundException
    {
        Optional<OperationsEntity> operation = repository.findById(id);

        if(operation.isPresent()) {
            return operation.get();
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