package com.aidar.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTask(String sessionId, String task) {
        entityManager.persist(new Task(sessionId, task));
    }

    @Override
    public void deleteTaskList(String sessionId) {
        Query query = entityManager.createQuery("delete from Task t where t.sessionId= :sessionId");
        query.setParameter("sessionId", sessionId);
        query.executeUpdate();
    }
}
