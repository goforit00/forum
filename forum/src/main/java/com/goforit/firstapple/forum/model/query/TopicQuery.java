package com.goforit.firstapple.forum.model.query;

public class TopicQuery {

    private String topicTitle;
    
    private long userId=-1;

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
