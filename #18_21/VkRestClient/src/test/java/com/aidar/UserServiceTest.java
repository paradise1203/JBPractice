package com.aidar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-servlet.xml"})
public class UserServiceTest {

    private UserApi user;

    private String[] artists = {"Eminem", "Mozart", "John Newman"};

    @Before
    public void setUp() {
        List<Audio> audioList = new LinkedList<>();
        audioList.add(new Audio(0, 1, artists[0], "Beautiful"));
        audioList.add(new Audio(1, 1, artists[0], "Not afraid"));
        audioList.add(new Audio(2, 1, artists[1], "Adagio 5"));
        audioList.add(new Audio(3, 1, artists[2], "Love me again"));
        AudioCollection audioCollection = new AudioCollection(audioList.size(), audioList);
        AudioCollectionResponse audios = new AudioCollectionResponse(audioCollection);
        user = new UserApiImpl(new Token(), audios);
    }

    @Test
    public void filterAudiosByArtistTest() {
        AudioCollectionResponse audioCollectionResponse = new UserServiceImpl().filterAudiosByArtist(user, "Eminem");
        AudioCollection audios = audioCollectionResponse.getResponse();
        boolean flag = true;
        if ((int) audios.getCount() != 2)
            flag = false;
        ListIterator<Audio> it = audios.getItems().listIterator();
        while (it.hasNext())
            if (!it.next().getArtist().equals(artists[0]))
                flag = false;
        assertTrue(flag);
    }

}
