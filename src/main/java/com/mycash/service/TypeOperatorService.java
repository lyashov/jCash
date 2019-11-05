package com.mycash.service;

import com.mycash.exception.RecordNotFoundException;
import com.mycash.model.TypeOperationsEntity;
import com.mycash.model.UsersEntity;
import com.mycash.repository.TypeOperatorRepository;
import com.mycash.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOperatorService {
     
    @Autowired
    TypeOperatorRepository repository;


    public List<TypeOperationsEntity> getAllTypeOperations()
    {
        List<TypeOperationsEntity> typeOperationsList = repository.findAll();
         
        if(typeOperationsList.size() > 0) {
            return typeOperationsList;
        } else {
            return new ArrayList<TypeOperationsEntity>();
        }
    }

    public TypeOperationsEntity getTypeOperationsById(Long id) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> typeOperations = repository.findById(id);

        if(typeOperations.isPresent()) {
            return typeOperations.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public TypeOperationsEntity createOrUpdateTypeOperations(TypeOperationsEntity entity) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> typeOperations = repository.findById(entity.getId());

        if(typeOperations.isPresent())
        {
            TypeOperationsEntity newEntity = typeOperations.get();
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
        Optional<TypeOperationsEntity> typeOperations = repository.findById(id);

        if(typeOperations.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}