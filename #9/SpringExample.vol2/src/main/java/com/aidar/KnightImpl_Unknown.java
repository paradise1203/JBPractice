package com.aidar;

public class KnightImpl_Unknown implements Knight {

    /*
    Если делать через аннотации получается следующее:
    @Autowired - даем понять, что мы хотим, чтобы параметр инициализировался автоматически, но не даем явно никакой id, как делали
    это в xml-файле. Поэтому если в конфигурации будут два бина с одинаковым параметром class и разными id, система нас не поймет.
    @Qualifier("quest") - здесь то нам и пригождается вот эта штука, которая однозначно определяет бин (по id), который нам нужен.
    */
    private Quest quest;

    public KnightImpl_Unknown() {}

    public KnightImpl_Unknown(Quest quest) {
        this.quest = quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public boolean embarkOnQuest() {
        return quest.embark("Unknown");
    }
}
