package com.aidar;

import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public AudioCollectionResponse filterAudiosByArtist(UserApi user, String artist) {
        List<Audio> audios = user.getAudios().getResponse().getItems();
        List<Audio> res = new LinkedList<>();
        audios.stream().forEach(audio -> {
            if (audio.getArtist().equals(artist))
                res.add(audio);
        });
        return new AudioCollectionResponse(new AudioCollection(res.size(), res));
    }

}
