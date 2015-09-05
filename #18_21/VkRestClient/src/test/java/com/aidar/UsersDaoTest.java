package com.aidar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-servlet.xml"})
public class UsersDaoTest {

    @Autowired
    private UsersDAO dao;

    @Test
    public void addAndGet() {
        String sessionId = "some sessionId";
        dao.addUser(sessionId);
        UserApi user = dao.getUser(sessionId);
        assertTrue(user != null);
    }

    @Test
    public void getWithoutAdd() {
        String sessionId = "another sessionId";
        UserApi user = dao.getUser(sessionId);
        assertTrue(user == null);
    }

}
