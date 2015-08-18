package com.aidar.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateToDoListDAO implements ToDoListDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public HibernateToDoListDAO() {
    }

    public HibernateToDoListDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void addTask(String sessionId, String task) {
        Task t = new Task(sessionId, task);
        currentSession().save(t);
    }

    @Override
    public List<Task> getTaskList(String sessionId) {
        /* Using criteria
        Criteria criteria = currentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("sessionId", sessionId));
        return criteria.list();
        */
        Query query = currentSession().createQuery("from Task where sessionId= :sessionId");
        query.setParameter("sessionId", sessionId);
        return query.list();
    }

    @Override
    public void deleteTaskList(String sessionId) {
        Query query = currentSession().createQuery("delete Task where sessionId= :sessionId");
        query.setParameter("sessionId", sessionId);
        query.executeUpdate();
    }

}
