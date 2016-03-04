package com.goforit.firstapple.forum.model;

import java.sql.Date;


public class Post {
    
    private long id;
    
    private long topicId;
    
    private User user;
    
    private long  postSeqNum;

    private String postText;
    
    private long likeNum;
    
    private long dislikeNum;
    
    private Date createdTime;
    
    private Date modifiedTime;
    

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getTopicId() {
        return topicId;
    }


    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public long getPostSeqNum() {
        return postSeqNum;
    }


    public void setPostSeqNum(long postSeqNum) {
        this.postSeqNum = postSeqNum;
    }


    public String getPostText() {
        return postText;
    }


    public void setPostText(String postText) {
        this.postText = postText;
    }


    public long getLikeNum() {
        return likeNum;
    }


    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }


    public long getDislikeNum() {
        return dislikeNum;
    }


    public void setDislikeNum(long dislikeNum) {
        this.dislikeNum = dislikeNum;
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
        return "Post{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", user=" + user +
                ", postSeqNum=" + postSeqNum +
                ", postText='" + postText + '\'' +
                ", likeNum=" + likeNum +
                ", dislikeNum=" + dislikeNum +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
