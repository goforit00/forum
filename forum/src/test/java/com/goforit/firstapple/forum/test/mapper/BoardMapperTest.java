package com.goforit.firstapple.forum.test.mapper;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goforit.firstapple.forum.mapper.BoardMapper;
import com.goforit.firstapple.forum.model.Board;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class BoardMapperTest {
    
    @Autowired 
    BoardMapper boardMapper;
    
    @Test
    public void testBoardMapper(){
        Board board=new Board();
        board.setName("test");
        board.setTopicNum(0);
        board.setDes("test des");
        board.setCreatedTime(new Date());
        board.setModifiedTime(new Date());
        
        boardMapper.insert(board);
        long boardId=board.getId();
        Board getR=boardMapper.get(boardId);
        assertTrue(null!=getR);
        
        getR.setName("test2");
        boardMapper.update(getR);
        Board updateR=boardMapper.get(boardId);
        assertTrue("test2".equals(updateR.getName()));
        
        boardMapper.delete(boardId);
        Board deleteR=boardMapper.get(boardId);
        assertTrue(deleteR==null);
        
        
    }

}
