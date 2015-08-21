package com.aidar.dao;

import java.util.List;

public interface ToDoListDAO {

    public List<Task> getTaskList(String sessionId);

    public void addTask(String sessionId, String task);

    public void deleteTaskList(String sessionId);

}
