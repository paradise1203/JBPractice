package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioCollection {

    private Number count;
    private List<Audio> items;

    public AudioCollection() {
    }

    public AudioCollection(Number count, List<Audio> items) {
        this.count = count;
        this.items = items;
    }

    public Number getCount() {
        return count;
    }

    public void setCount(Number count) {
        this.count = count;
    }

    public List<Audio> getItems() {
        return items;
    }

    public void setItems(List<Audio> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AudioCollection{" +
                "count='" + count + '\'' +
                ", items=" + items +
                '}';
    }

}
