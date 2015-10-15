package com.goforit.firstapple.forum.model;

import java.util.Date;


public class Topic {

    private long id;
    
    private long boardId;
    
    private String topicTitle;
    
    private User user;
    
    /** 浏览量  */
    private int viewNum;
    
    /** 回帖数 */
    private int postNum;
    

    /** 帖子最后回复的时间 */
    private Date lastPostTime;

    /** 主题帖子创建的时间  */
    private Date createdTime;
    
    private Date modifiedTime;
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastPostTime() {
        return lastPostTime;
    }

    public void setLastPostTime(Date lastPostTime) {
        this.lastPostTime = lastPostTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Topic [id=" + id + ", boardId=" + boardId + ", topicTitle=" + topicTitle
               + ", user=" + user + ", viewNum=" + viewNum + ", postNum=" + postNum
               + ", lastPostTime=" + lastPostTime + ", createdTime=" + createdTime
               + ", modifiedTime=" + modifiedTime + "]";
    }


    
    
}
