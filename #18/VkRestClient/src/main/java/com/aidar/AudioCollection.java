package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioCollection {

    private String count;
    private List<Audio> items;

    public AudioCollection() {
    }

    public AudioCollection(String count, List<Audio> items) {
        this.count = count;
        this.items = items;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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
