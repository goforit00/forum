package com.goforit.firstapple.forum.test.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import com.goforit.firstapple.forum.mapper.TopicMapper;
import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.TopicQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TopicMapperTest {
    
    @Autowired
    private TopicMapper topicMapper;
    
    @Test
    public void testTopicMapper(){
        
        User user=new User();
        user.setId(1);
        user.setName("junqing.fjq");
        user.setPasswd("xxx");
        
        Topic topic=new Topic();
        topic.setBoardId(1);
        topic.setCreatedTime(new Date());
        topic.setLastPostTime(new Date());
        topic.setModifiedTime(new Date());
        topic.setPostNum(1);
        topic.setUser(user);
        topic.setTopicTitle("hello kitty");
        topic.setViewNum(1);
        
        //insert
        int insertR=topicMapper.insert(topic);
        assertTrue(insertR!=0);
        
        //query
        TopicQuery query=new TopicQuery();
        query.setUserId(1);
        query.setTopicTitle("hello kitty");
        List<Topic> topics=topicMapper.query(query);
        
        assertTrue(topics.size()==1);
        assertTrue(!CollectionUtils.isEmpty(topics));
        
        //update
        long topicId=topics.get(0).getId();
        topics.get(0).setBoardId(2);
        topicMapper.update(topics.get(0));
        
        Topic updateR=topicMapper.get(topicId);
        assertTrue(updateR!=null);
        assertTrue(updateR.getBoardId()==2);
        
        //delete
        topicMapper.delete(topicId);
        Topic deleteR=topicMapper.get(topicId);
        assertTrue(deleteR==null);
        
    }

}
