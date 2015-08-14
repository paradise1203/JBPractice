package com.aidar.data;

public class Task {

    private int index;
    private String text;

    Task(int index, String text) {
        this.index = index;
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setText(String text) {
        this.text = text;
    }
}
