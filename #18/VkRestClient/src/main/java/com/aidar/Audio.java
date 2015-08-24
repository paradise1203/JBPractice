package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio {

    private String id;
    private String owner_id;
    private String artist;
    private String title;
    private String duration;
    private String date;
    private String url;
    private String lyrics_id;
    private String genre_id;

    public Audio() {
    }

    public Audio(String id, String owner_id, String artist, String title, String duration, String date, String url, String lyrics_id, String genre_id) {
        this.id = id;
        this.owner_id = owner_id;
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.date = date;
        this.url = url;
        this.lyrics_id = lyrics_id;
        this.genre_id = genre_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLyrics_id() {
        return lyrics_id;
    }

    public void setLyrics_id(String lyrics_id) {
        this.lyrics_id = lyrics_id;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id='" + id + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", date='" + date + '\'' +
                ", url='" + url + '\'' +
                ", lyrics_id='" + lyrics_id + '\'' +
                ", genre_id='" + genre_id + '\'' +
                '}';
    }

}
