package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioCollectionResponse {

    private AudioCollection response;

    public AudioCollectionResponse() {}

    public AudioCollectionResponse(AudioCollection audioCollection) {
        response=audioCollection;
    }

    public AudioCollection getResponse() {
        return response;
    }

    public void setResponse(AudioCollection response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "AudioCollectionResponse{" +
                "response=" + response +
                '}';
    }
}
