package com.goforit.firstapple.forum.model;

import java.sql.Date;

public class LoginLog {
    
    private long id;
    
    private long userId;
    
    private String loginArea;
    
    private String ip;
    
    private Date loginTime;
    
    /**
     * ÊÇ·ñµÇÂ¼³É¹¦
     *   */
    private boolean isSuc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginArea() {
        return loginArea;
    }

    public void setLoginArea(String loginArea) {
        this.loginArea = loginArea;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public boolean isSuc() {
        return isSuc;
    }

    public void setSuc(boolean isSuc) {
        this.isSuc = isSuc;
    }

    @Override
    public String toString() {
        return "LoginLog [id=" + id + ", userId=" + userId + ", loginArea=" + loginArea + ", ip="
               + ip + ", loginTime=" + loginTime + ", isSuc=" + isSuc + "]";
    }

    
    
}
