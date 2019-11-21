package com.jCash.repository;


import com.jCash.configs.User;
import com.jCash.model.OperationsEntity;
import com.jCash.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface OperationsRepository
        extends JpaRepository<OperationsEntity, Long> {
    List<OperationsEntity> getAllByUser(UsersEntity usersEntity);


   //@Query("SELECT op FROM OperationsEntity op JOIN FETCH op.user")
    List<OperationsEntity> findByUser(UsersEntity usersEntity);

}
