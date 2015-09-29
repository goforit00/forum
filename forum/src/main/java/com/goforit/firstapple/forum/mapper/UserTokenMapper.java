package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.UserToken;

@Repository
public interface UserTokenMapper extends BaseMapper{
    
    String INSERT="insert into user_token(user_id,token,modified_time) values(#{user.id},#{token},now())";
    
    String UPDATE="update user_token set token=#{token}, modified_time=now() where id=#{id}";
    
    String UPDATE_BY_UID="update user_token set token=#{token}, modified_time=now() where user_id=#{user.id}";
    
    String GET="select * from user_token where id=#{id}";
    
    String FIND_BY_UID="select * from user_token where user_id=#{userId}";
    
    String FIND_BY_TOKEN="select * from user_token where token=#{token}";
    
    String DELETE="delete from user_token where id=#{id}";
    
    String DELETE_BY_UID="delete from user_token where user_id=#{userId}";
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="token",column="token"),
        @Result(property="modifiedTime",column="modified_time"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get")),
        })
    @Select(GET)
    UserToken get(Serializable id);
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="token",column="token"),
        @Result(property="modifiedTime",column="modified_time"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get"))
    })
    @Select(FIND_BY_UID)
    UserToken findByUserId(long userId);
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="token",column="token"),
        @Result(property="modifiedTime",column="modified_time"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get"))
    })
    @Select(FIND_BY_TOKEN)
    UserToken findByToken(String token);
    
    @Insert(INSERT)
    @Options(useGeneratedKeys=true,keyProperty="id",flushCache=true)
    int insert(UserToken object);
    
    @Update(UPDATE)
    @Options(flushCache=true,useCache=true)
    int update(UserToken token);
    
    @Update(UPDATE_BY_UID)
    @Options(flushCache=true,useCache=true)
    int updateByUserId(UserToken token);
    
    @Delete(DELETE)
    int delete(Serializable id);
    
    @Delete(DELETE_BY_UID)
    int deleteByUserId(long userId);
    
}
