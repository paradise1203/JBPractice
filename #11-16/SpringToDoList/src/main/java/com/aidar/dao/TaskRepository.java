package com.aidar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>, TaskRepositoryCustom {

    public List<Task> findBySessionId(String sessionId);

}
