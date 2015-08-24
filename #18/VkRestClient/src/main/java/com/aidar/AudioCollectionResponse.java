package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ainurminibaev on 25.08.15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioCollectionResponse {

    private AudioCollection response;

    public AudioCollection getResponse() {
        return response;
    }

    public void setResponse(AudioCollection response) {
        this.response = response;
    }
}
