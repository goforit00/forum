package com.goforit.firstapple.forum.model;

public class Board {
    
    private long id;

    private String name;
    
    private String desc;
    
    private int topicNum;

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

    @Override
    public String toString() {
        return "Board [id=" + id + ", name=" + name + ", desc=" + desc + ", topicNum=" + topicNum
               + "]";
    }
    
    
}
