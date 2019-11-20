package com.jCash.service;

import com.jCash.exception.RecordNotFoundException;
import com.jCash.model.UsersEntity;
import com.jCash.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
     
    @Autowired
    UsersRepository repository;


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

    public List<UsersEntity> getAllUsers()
    {
        List<UsersEntity> usersList = repository.findAll();

        if(usersList.size() > 0) {
            return usersList;
        } else {
            return new ArrayList<UsersEntity>();
        }
    }


    public UsersEntity getUserById(Long id) throws RecordNotFoundException
    {
        Optional<UsersEntity> user = repository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }

    public UsersEntity getUserByName(String username) throws RecordNotFoundException
    {
        Optional<UsersEntity> user = Optional.ofNullable(repository.findByUsername(username));

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }


  /*  public TypeOperationsEntity createOrUpdateDocor(TypeOperationsEntity entity) throws RecordNotFoundException
    {
        Optional<TypeOperationsEntity> doctor = repository.findById(entity.getId());

        if(doctor.isPresent())
        {
            TypeOperationsEntity newEntity = doctor.get();
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
  public void save(UsersEntity usersEntity)
  {
      repository.save(usersEntity);
  }

    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        Optional<UsersEntity> user = repository.findById(id);
         
        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }
}