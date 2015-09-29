package com.goforit.firstapple.forum.model;

import java.sql.Date;

public class Board {
    
    private long id;

    private String name;
    
    private String desc;
    
    private int topicNum;
    
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(int topicNum) {
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

    @Override
    public String toString() {
        return "Board [id=" + id + ", name=" + name + ", desc=" + desc + ", topicNum=" + topicNum
               + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }

}
