package com.aidar.dao;

public interface TaskRepositoryCustom {

    public void addTask(String sessionId, String task);

    public void deleteTaskList(String sessionId);

}
