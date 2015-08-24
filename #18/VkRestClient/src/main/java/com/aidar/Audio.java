package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio {

    private Number id;
    private Number owner_id;
    private String artist;
    private String title;

    public Audio() {
    }

    public Audio(Number id, Number owner_id, String artist, String title) {
        this.id = id;
        this.owner_id = owner_id;
        this.artist = artist;
        this.title = title;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public Number getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Number owner_id) {
        this.owner_id = owner_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", owner_id=" + owner_id +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}
