package com.mycash.web;

import com.mycash.exception.RecordNotFoundException;
import com.mycash.model.UsersEntity;
import com.mycash.service.UsersServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/users")
public class UsersController
{
    @Autowired
    UsersServiceDAO service;
 
    @GetMapping
    public ResponseEntity<List<UsersEntity>> getAllEmployees() {
        List<UsersEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<UsersEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<UsersEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        UsersEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<UsersEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<UsersEntity> createOrUpdateEmployee(UsersEntity employee)
                                                    throws RecordNotFoundException {
        UsersEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<UsersEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}