package com.aidar.data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Database {

    private static LinkedHashMap<String, List<Task>> taskLists;

    static {
        taskLists = new LinkedHashMap<>();
    }

    public static List<Task> getTaskList(String name) {
        return taskLists.get(name);
    }

    public static void addTaskList(String name) {
        taskLists.put(name, new LinkedList<>());
    }

    public static void addTask(String name, String text) {
        taskLists.get(name).add(new Task(text));
    }

}
