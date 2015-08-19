package com.aidar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class JpaToDoListDAO implements ToDoListDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public JpaToDoListDAO() {
    }

    public JpaToDoListDAO(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public List<Task> getTaskList(String sessionId) {
        Query query = entityManager.createQuery("select t from Task t where t.sessionId= :sessionId");
        query.setParameter("sessionId", sessionId);
        return query.getResultList();
    }

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
