package com.aidar;

import java.util.LinkedHashMap;
import java.util.Map;

public class UsersDAOImpl implements UsersDAO {

    private Map<String, UserApi> users;

    public UsersDAOImpl() {
        users=new LinkedHashMap<String, UserApi>();
    }

    @Override
    public UserApi getUser(String sessionId) {
        return users.get(sessionId);
    }

    @Override
    public void addUser(String sessionId) {
        users.put(sessionId, new UserApiImpl());
    }

}
