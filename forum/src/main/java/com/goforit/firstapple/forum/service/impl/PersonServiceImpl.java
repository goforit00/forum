package com.goforit.firstapple.forum.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import sun.util.logging.resources.logging;

import com.goforit.firstapple.forum.mapper.LoginLogMapper;
import com.goforit.firstapple.forum.mapper.UserMapper;
import com.goforit.firstapple.forum.mapper.UserTokenMapper;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.UserToken;
import com.goforit.firstapple.forum.model.query.UserQuery;
import com.goforit.firstapple.forum.service.PersonService;
import com.goforit.firstapple.forum.util.Md5Utils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private LoginLogMapper loginLogMapper;
    
    @Autowired
    private UserTokenMapper userTokenMapper;
     
    @Override
    public String login(String loginName, String password) {
        
        UserQuery query=new UserQuery();
        query.setName(loginName);
        query.setPasswd(password);
        List<User> users=userMapper.query(query);
        if(CollectionUtils.isEmpty(users)){
            throw new RuntimeException("not find user:"+loginName);
        }
        
        User user=users.get(0);
        String token= generateUserToken(String.valueOf(user.getId()));
    
        userTokenMapper.deleteByUserId(user.getId());
        UserToken userToken=new UserToken();
        userToken.setToken(token);
        userToken.setUser(user);
        userTokenMapper.insert(userToken);
        
        return token;
        
    }

    @Override
    public void logout(String userName) {
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    private String generateUserToken(String userId){
        byte[] tokenBytes = Md5Utils.encrypt(
            String.valueOf(System.currentTimeMillis()),
            new StringBuilder().append(String.valueOf(userId)).append(UUID.randomUUID())
                .toString()).getBytes();
        String token = "hmac" + String.valueOf(userId) + ":"
                       + new String(Base64.encode(tokenBytes));
        return token;
    }
    
}
