package com.jCash.service;

import com.google.common.collect.ImmutableList;
import com.jCash.configs.Role;
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

    public UsersEntity create(String username, String password) {
            UsersEntity entityNew = new UsersEntity();
            entityNew.setId(4L);
            entityNew.setActive(true);
            entityNew.setUsername(username);
            entityNew.setPassword(password);
            entityNew.setAuthorities(ImmutableList.of(Role.USER));
            entityNew.setAccountNonExpired(true);
            entityNew.setAccountNonLocked(true);
            entityNew.setEnabled(true);
            entityNew.setCredentialsNonExpired(true);
            return repository.save(entityNew);
    }

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