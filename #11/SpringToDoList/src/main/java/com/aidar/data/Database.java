package com.aidar.data;

import java.util.LinkedList;
import java.util.List;

public class Database {

    private static List<Task> tasks;
    private static int index = 0;

    static {
        tasks = new LinkedList<>();
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(String text) {
        tasks.add(new Task(++index, text));
    }

}
