package com.goforit.firstapple.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goforit.firstapple.forum.mapper.UserMapper;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private UserMapper userMapper;
     
    @Override
    public void processSave() {
        User user=userMapper.get(1);
        System.err.println("hello");
        System.err.println(user);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

   

}
