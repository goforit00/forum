package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.goforit.firstapple.forum.model.Board;

public interface BoardMapper extends BaseMapper{
    
    String INSERT="insert into board(name,desc,topic_num,create_time,modified_time) values(#{name},#{desc},#{topic_num},#{createTime},#{modifiedTime})";
    
    String UPDATE="update board set name=#{name},desc=#{desc},topic_num=#{topicNum},modified_time=now() where id=#{id}";
    

    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="name",column="name"),
        @Result(property="desc",column="desc"),
        @Result(property="topicNum",column="topic_num"),
        @Result(property="createdTime",column="create_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @Select("select * from board where id=#{id}")
    Board get(Serializable id);
    
    @Insert(INSERT)
    @Options(useGeneratedKeys=true,flushCache=true,keyProperty="id")
    int insert(Board board);
    
    @Update(UPDATE)
    @Options(useCache=true,flushCache=true)
    int update(Board board);
    
    @Delete("delete from board where id=#{id}")
    int delete(Serializable id);
    
    @Select("select * from board where name=#{name}")
    Board find(String name);
    
}
