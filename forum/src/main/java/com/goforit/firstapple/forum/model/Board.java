package com.goforit.firstapple.forum.model;

import java.util.Date;



public class Board {
    
    private long id;

    private String name;
    
    private String des;
    
    private long topicNum;
    
    private Date createdTime;
    
    private Date modifiedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public long getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(long topicNum) {
        this.topicNum = topicNum;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    

}
