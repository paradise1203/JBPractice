package com.aidar;

public interface UserApi {

    public Token getToken(String url, String code);

    public AudioCollectionResponse getAudios(String url);

    public String deleteAudio(String url);

}
