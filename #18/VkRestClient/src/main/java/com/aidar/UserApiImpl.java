package com.aidar;

import org.springframework.web.client.RestTemplate;

public class UserApiImpl implements UserApi {

    private RestTemplate restTemplate;
    private Token token;
    private AudioCollectionResponse audios;

    public UserApiImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Token getToken(String code) {
        token = restTemplate.getForObject("https://oauth.vk.com/access_token?" +
                "client_id=5042953&client_secret=t6VTlzMUhXStuXOoUzsV&redirect_uri=http://localhost:8080/login&code=" +
                code, Token.class);
        return token;
    }

    @Override
    public AudioCollectionResponse getAudios() {
        audios = restTemplate.getForObject("https://api.vk.com/method/audio.get?" +
                "v=5.37&access_token=" + token.getAccessToken(), AudioCollectionResponse.class);
        return audios;
    }

    @Override
    public String deleteAudio() {
        String res = restTemplate.getForObject("https://api.vk.com/method/audio.delete?" +
                "audio_id=" + audios.getResponse().getItems().get(0).getId() + "&owner_id=" + token.getUserId() +
                "&access_token=" + token.getAccessToken(), String.class);
        return res;
    }

}
