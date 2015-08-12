package com.aidar;

public class KnightImpl_Arthur implements Knight {

    private String name;
    private Quest quest;

    public KnightImpl_Arthur() {}

    public KnightImpl_Arthur(String name, Quest quest) {
        this.name = name;
        this.quest = quest;
    }

    @Override
    public boolean embarkOnQuest() {
        return quest.embark(name);
    }
}
