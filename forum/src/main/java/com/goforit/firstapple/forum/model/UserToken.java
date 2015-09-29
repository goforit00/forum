package com.goforit.firstapple.forum.model;

import java.util.Date;



public class UserToken {
    
    private long id;
    
    private User user;
    
    private String token;
    
    private Date modifiedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "UserToken [id=" + id + ", user=" + user + ", token=" + token + ", modifiedTime="
               + modifiedTime + "]";
    }
    
    

}
