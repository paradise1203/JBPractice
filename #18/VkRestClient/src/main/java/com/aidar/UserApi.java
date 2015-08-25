package com.aidar;

public interface UserApi {

    public Token getToken(String code);

    public AudioCollectionResponse getAudios();

    public String deleteAudio();

}
