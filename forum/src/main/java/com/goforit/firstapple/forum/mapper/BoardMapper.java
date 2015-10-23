package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.goforit.firstapple.forum.model.Board;



@Repository
public interface BoardMapper extends BaseMapper{
    
    String INSERT="insert into board(name,des,topic_num,created_time,modified_time) values(#{name},#{des},#{topicNum},now(),now())";
//    String INSERT="insert into board(name,des,topic_num,created_time,modified_time) values('1','1','1',now(),now())";
    
    String UPDATE="update board set name=#{name},des=#{des},topic_num=#{topicNum},modified_time=now() where id=#{id}";
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="name",column="name"),
        @Result(property="des",column="des"),
        @Result(property="topicNum",column="topic_num"),
        @Result(property="createdTime",column="created_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @Select("select * from board where id=#{id}")
    Board get(Serializable id);
    
    @Insert(INSERT)
    @Options(useGeneratedKeys=true,keyProperty="id",flushCache=true)
    int insert(Board board);
    
    @Update(UPDATE)
    @Options(useCache=true,flushCache=true)
    int update(Board board);
    
    @Delete("delete from board where id=#{id}")
    int delete(Serializable id);
    
    @Select("select * from board where name=#{name}")
    Board find(String name);
    
}
