package com.diagnoses.service;

import com.diagnoses.exception.RecordNotFoundException;
import com.diagnoses.model.DiagnosesEmptity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOperatorService {
     
    @Autowired
    TypeOperatorRepository repository;


    public List<DiagnosesEmptity> getAllTypeOperations()
    {
        List<DiagnosesEmptity> typeOperationsList = repository.findAll();
         
        if(typeOperationsList.size() > 0) {
            return typeOperationsList;
        } else {
            return new ArrayList<DiagnosesEmptity>();
        }
    }

    public DiagnosesEmptity getTypeOperationsById(Long id) throws RecordNotFoundException
    {
        Optional<DiagnosesEmptity> typeOperations = repository.findById(id);

        if(typeOperations.isPresent()) {
            return typeOperations.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public DiagnosesEmptity createOrUpdateTypeOperations(DiagnosesEmptity entity) throws RecordNotFoundException
    {
        Optional<DiagnosesEmptity> typeOperations = repository.findById(entity.getId());

        if(typeOperations.isPresent())
        {
            DiagnosesEmptity newEntity = typeOperations.get();
            newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteTypeOperationsById(Long id) throws RecordNotFoundException
    {
        Optional<DiagnosesEmptity> typeOperations = repository.findById(id);

        if(typeOperations.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}