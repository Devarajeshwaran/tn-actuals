package com.tn.actuals.dao;


import com.tn.actuals.dto.District;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
@Service
public class DistrictRepoServiceImpl implements DistrictRepoService {

    @PersistenceContext
    EntityManager entityManager;

    public District findById(int id) {
        return entityManager.find(District.class, id);
    }

    public List<District> findAll() {
        return entityManager.createNamedQuery("findAll", District.class).getResultList();
    }

    public List<District> findByDistrictCode(int id){
        return entityManager.createNamedQuery("findByDistrictCode", District.class)
            .setParameter(1, id)
            .getResultList();
    }

    @Transactional
    public void addDistrict(District district){
        entityManager.persist(district);
        entityManager.flush();
    }

    @Transactional
    public void updateDistrict(District district){
        entityManager.merge(district);
        entityManager.flush();
    }

    @Transactional
    public void deleteDistrict(District district){
        entityManager.remove(district);
        entityManager.flush();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
