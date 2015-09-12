package com.goforit.firstapple.forum.model;

import java.sql.Date;


public class Post {
    
    private long id;
    
    private long topicId;
    
    private User user;
    
    /** 帖子回复的序号，即楼数 */
    private int  postSeqNum;

    /** 梯子回复的内容 */
    private String postText;
    
    private Date createdTime;

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

    public int getPostSeqNum() {
        return postSeqNum;
    }

    public void setPostSeqNum(int postSeqNum) {
        this.postSeqNum = postSeqNum;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", topicId=" + topicId + ", user=" + user + ", postSeqNum="
               + postSeqNum + ", postText=" + postText + ", createdTime=" + createdTime + "]";
    }
    
    
}
