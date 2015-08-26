package com.aidar;

public interface UsersDAO {

    public UserApi getUser(String sessionId);

    public void addUser(String sessionId);

}
