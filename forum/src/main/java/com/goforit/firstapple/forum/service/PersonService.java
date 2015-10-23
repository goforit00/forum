package com.goforit.firstapple.forum.service;


public interface PersonService {
    
    public String login(String loginName,String password);
    
    public void logout(String userName);
    
}
