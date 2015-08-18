package com.aidar.dao;

import com.aidar.data.Task;

import java.util.List;

public interface ToDoListDAO {

    public List<Task> getTaskList(String sessionId);

    public void addTask(String sessionId, String task);

}
