package com.goforit.firstapple.forum.test.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.goforit.firstapple.forum.mapper.LoginLogMapper;
import com.goforit.firstapple.forum.model.LoginLog;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.LoginLogQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class LoginLogMapperTest {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Test
    public void testLoginLogMapper() {
        
        LoginLog loginLog =new LoginLog();
        loginLog.setIp("127.0.0.1");
        loginLog.setSuc(true);
        loginLog.setLoginArea("hz");
        
        User user=new User();
        user.setId(1);
        loginLog.setUser(user);
        
        loginLogMapper.insert(loginLog);
        long loginLogId=loginLog.getId();
        
        LoginLog getR=loginLogMapper.get(loginLogId);
        assertTrue(null!=getR);
        
        LoginLogQuery query=new LoginLogQuery();
        query.setIp("127.0.0.1");
        List<LoginLog>  loginLogs=loginLogMapper.query(query);
        assertTrue(!CollectionUtils.isEmpty(loginLogs));
        
       
    }

}
