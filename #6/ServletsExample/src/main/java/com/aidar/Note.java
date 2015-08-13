package com.aidar;

public class Note {

    String txt;

    Note(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Note{" +
                "txt='" + txt + '\'' +
                '}';
    }
}
