package com.aidar;

public interface UserApi {

    public Token getNewToken(String url, String code);
    public Token getToken();

    public AudioCollectionResponse getNewAudios(String url);
    public AudioCollectionResponse getAudios();

    public String deleteAudio(String url);

}
