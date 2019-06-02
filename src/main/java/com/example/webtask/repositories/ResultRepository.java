package com.example.webtask.repositories;

import com.example.webtask.domain.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ResultRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Result result) {
        entityManager.persist(result);
        entityManager.flush();
    }
}
