package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.UserQuery;

@Repository
public interface UserMapper {

    String INSERT = "insert into user(name,passwd,real_name,phone_number,email,status,created_time,modified_time) "
                    + "values(#{name},#{passwd},#{realName},#{phoneNumber},#{email},#{status},now(),now()) ";

    String UPDATE = "update user name=#{name},passwd=#{passwd},real_name=#{realName},phone_number=#{phoneNumber},"
                    + "email=#{email},status=#{status},modified_time=now() where id=#{id}";

    @Results({ @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "passwd", column = "passwd"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "modifiedTime", column = "modified_time") })
    @Select("select * from user where id=#{id}")
    User get(Serializable id);

    @Results({ @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "passwd", column = "passwd"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status"),
            @Result(property = "createdTime", column = "created_time"),
            @Result(property = "modifiedTime", column = "modified_time") })
    @SelectProvider(type = UserProvider.class, method = "query")
    List<User> query(Object params);

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true)
    int create(User user);
    
    @Update(UPDATE)
    @Options(flushCache=true,useCache=true)
    int update(User user);
    
    @Delete("delete from user where id=#{id}")
    int delete(Serializable id);

    class UserProvider {
        public String query(UserQuery query) {
            SQL sql = new SQL() {
                {
                    SELECT("*");
                    FROM("user u");
                }
            };
            appendWhereClause(sql, query);

            return sql.toString();
        }

        private void appendWhereClause(SQL sql, UserQuery query) {
            if (null == query) {
                return;
            }

            if (null != query.getName()) {
                sql.WHERE("name = #{name}");
            }

        }
    }
}
