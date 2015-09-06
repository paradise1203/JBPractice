package com.aidar;

import org.springframework.web.client.RestTemplate;

public class UserApiImpl implements UserApi {

    private RestTemplate restTemplate;
    private Token token;
    private AudioCollectionResponse audios;

    public UserApiImpl() {
        restTemplate = new RestTemplate();
    }

    public UserApiImpl(Token token, AudioCollectionResponse audios) {
        this.token = token;
        this.audios = audios;
    }

    public Token getToken() {
        return token;
    }

    public AudioCollectionResponse getAudios() {
        return audios;
    }

    @Override
    public Token getNewToken(String url, String code) {
        token = restTemplate.getForObject(url + "code=" + code, Token.class);
        return token;
    }

    @Override
    public AudioCollectionResponse getNewAudios(String url) {
        audios = restTemplate.getForObject(url + "v=5.37&access_token=" + token.getAccessToken(), AudioCollectionResponse.class);
        return audios;
    }

    @Override
    public String deleteAudio(String url) {
        return restTemplate.getForObject(url + "audio_id=" + audios.getResponse().getItems().get(0).getId() +
                "&owner_id=" + token.getUserId() + "&access_token=" + token.getAccessToken(), String.class);
    }

}
