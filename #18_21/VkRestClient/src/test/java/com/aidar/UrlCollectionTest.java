package com.aidar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-servlet.xml"})
public class UrlCollectionTest {

    @Autowired
    private UrlCollection urls;

    @Test
    public void urlsNotNull() {
        boolean flag = false;
        if (urls.getAuthorizeUrl() != null && urls.getTokenUrl() != null &&
                urls.getAudiosUrl() != null && urls.getDeleteAudioUrl() != null)
            flag = true;
        else
            flag = false;
        assertTrue(flag);
    }

}
