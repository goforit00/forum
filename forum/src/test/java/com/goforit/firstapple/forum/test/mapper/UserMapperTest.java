package com.goforit.firstapple.forum.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goforit.firstapple.forum.mapper.UserMapper;
import com.goforit.firstapple.forum.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;

    
    @Test
    public void testUserMapper(){
        System.err.println(userMapper.get(1));
        User user=new User();
        user.setName("test");
        user.setPasswd("test");
        System.err.println(userMapper.create(user));
    }
}
