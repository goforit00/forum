package com.goforit.firstapple.forum.test.mapper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goforit.firstapple.forum.mapper.PostMapper;
import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class PostMapperTest {
    
    @Autowired
    PostMapper postMapper;
    
    @Test
    public void testPostMapper(){
        
        Post post=new Post();
        post.setId(1);
        post.setLikeNum(1);
        post.setPostText("hello world");
        
        User user=new User();
        user.setId(1);
        post.setUser(user);
        
        post.setDislikeNum(1);
        
        
        postMapper.insert(post);
        long postId=post.getId();
        
        
        
        Post getR=postMapper.get(postId);
        assertTrue(getR!=null);
        System.err.println(getR);
        
        getR.setPostText("hello kitty");
        postMapper.update(getR);
        
        Post updateR=postMapper.get(postId);
        assertTrue("hello kitty".equals(updateR.getPostText()));
        
        postMapper.delete(postId);
        Post deleteR=postMapper.get(postId);
        assertTrue(deleteR==null);
        
        
    }

}
