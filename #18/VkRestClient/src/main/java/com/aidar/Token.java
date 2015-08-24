package com.aidar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private String access_token;
    private Number expires_in;
    private Number user_id;

    public Token() {
    }

    public Token(String access_token, Number expires_in, Number user_id) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Number getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Number expires_in) {
        this.expires_in = expires_in;
    }

    public Number getUser_id() {
        return user_id;
    }

    public void setUser_id(Number user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

}
