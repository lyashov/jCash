package com.diagnoses.service;

import com.diagnoses.exception.RecordNotFoundException;
import com.diagnoses.model.PacientsEntity;
import com.diagnoses.model.VisitsEntity;
import com.diagnoses.repository.PacientsRepository;
import com.diagnoses.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
     
    @Autowired
    VisitRepository repository;


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

    public List<VisitsEntity> getAllVisits()
    {
        List<VisitsEntity> pvisitsList = repository.findAll();

        if(pvisitsList.size() > 0) {
            return pvisitsList;
        } else {
            return new ArrayList<VisitsEntity>();
        }
    }

    public VisitsEntity getVisitById(Long id) throws RecordNotFoundException
    {
        Optional<VisitsEntity> visit = repository.findById(id);

        if(visit.isPresent()) {
            return visit.get();
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }

    public VisitsEntity createOrUpdateVisit(VisitsEntity entity) throws RecordNotFoundException
    {
        Optional<VisitsEntity> visit = repository.findById(entity.getId());

        if(visit.isPresent())
        {
            VisitsEntity newEntity = visit.get();
            newEntity.setId(entity.getId());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteVisitById(Long id) throws RecordNotFoundException
    {
        Optional<VisitsEntity> visit = repository.findById(id);
         
        if(visit.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No doctor record exist for given id");
        }
    }
}