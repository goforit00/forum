package com.goforit.firstapple.forum.model;

import java.sql.Date;

import com.goforit.firstapple.forum.enums.UserStatusEnum;

public class User {

    private long   id;

    private String name;

    private transient String passwd;
    
    private String realName;
    
    private String phoneNumber;

    private String email;
    
    private UserStatusEnum status;
    
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
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
        return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", realName="
               + realName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status="
               + status + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
    }


    
    
}
