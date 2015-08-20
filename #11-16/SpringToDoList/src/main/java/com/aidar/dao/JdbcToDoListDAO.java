package com.aidar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JdbcToDoListDAO implements ToDoListDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getTaskList(String sessionId) {
        List<Task> tasks = new LinkedList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT task FROM tasks WHERE sessionId=?", sessionId);
        for (Map row : rows) {
            Task task = new Task(row.get("task").toString());
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public void addTask(String sessionId, String text) {
        jdbcTemplate.update("INSERT INTO tasks (sessionId, task) VALUES (?, ?)", sessionId, text);
    }

    @Override
    public void deleteTaskList(String sessionId) {
        jdbcTemplate.update("DELETE FROM tasks WHERE sessionId=?", sessionId);
    }
}