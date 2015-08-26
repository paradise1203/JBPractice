package com.aidar;

public class UrlCollection {

    private String authorizeUrl;
    private String tokenUrl;
    private String audiosUrl;
    private String deleteAudioUrl;

    public UrlCollection() {
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getAudiosUrl() {
        return audiosUrl;
    }

    public void setAudiosUrl(String audiosUrl) {
        this.audiosUrl = audiosUrl;
    }

    public String getDeleteAudioUrl() {
        return deleteAudioUrl;
    }

    public void setDeleteAudioUrl(String deleteAudioUrl) {
        this.deleteAudioUrl = deleteAudioUrl;
    }

}
