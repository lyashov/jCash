package com.diagnoses.service;

import com.diagnoses.exception.RecordNotFoundException;
import com.diagnoses.model.OperationsEntity;
import com.diagnoses.model.TypeOperationsEntity;
import com.diagnoses.repository.TypeOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOperationsService {
     
    @Autowired
    TypeOperationsRepository repository;


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

    public List<TypeOperationsEntity> getAllTypeOperations()
    {
        List<TypeOperationsEntity> pacientsList = repository.findAll();

        if(pacientsList.size() > 0) {
            return pacientsList;
        } else {
            return new ArrayList<TypeOperationsEntity>();
        }
    }

    public TypeOperationsEntity getDoctorById(Long id) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> TypeOperations = repository.findById(id);

        if(TypeOperations.isPresent()) {
            return TypeOperations.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }

   /* public OperationsEntity createOrUpdateDocor(OperationsEntity entity) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> pacient = repository.findById(entity.getId());

        if(pacient.isPresent())
        {
            OperationsEntity newEntity = pacient.get();
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
*/
    public void deleteTypeOperationById(Long id) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> pacient = repository.findById(id);
         
        if(pacient.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }
}