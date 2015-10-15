package com.goforit.firstapple.forum.test.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goforit.firstapple.forum.mapper.UserTokenMapper;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.UserToken;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserTokenMapperTest {

    @Autowired
    private UserTokenMapper userTokenMapper;
    
    @Test
    public void create(){
        
        UserToken token=new UserToken();
        token.setModifiedTime(new Date());
        token.setToken("1111");
        
        User user=new User();
        user.setId(1);
        token.setUser(user);
        
        userTokenMapper.insert(token);
        
        UserToken re=userTokenMapper.get(token.getId());
        assertTrue(re!=null);
    }
    
    @Test
    public void delete(){
        userTokenMapper.delete(1);
        
        UserToken re=userTokenMapper.get(1);
        assertTrue(re==null);
    }
    
    @Test
    public void deleteByUID(){
        userTokenMapper.deleteByUserId(1);
        UserToken re=userTokenMapper.findByUserId(1);
        assertTrue(re==null);
        
    }
    
    @Test
    public void update(){
        
    }
}
