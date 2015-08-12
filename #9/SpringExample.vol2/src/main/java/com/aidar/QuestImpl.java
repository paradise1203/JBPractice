package com.aidar;

public class QuestImpl implements Quest {

    public QuestImpl() {}

    @Override
    public boolean embark(String name) {
        if (name.equalsIgnoreCase("Arthur"))
            return true;
        else
            return false;
    }
}
