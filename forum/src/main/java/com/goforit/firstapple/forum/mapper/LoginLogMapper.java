package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.goforit.firstapple.forum.model.LoginLog;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.LoginLogQuery;


@Repository
public interface LoginLogMapper extends BaseMapper {

    String INSERT = "insert into login_log(user_id,login_area,ip,login_time) values(#{user.id},#{loginArea},#{ip},now())";

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true)
    int insert(LoginLog loginLog);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = MAPPER_NAMESPACE
                                                                                                      + "UserMapper.get")),
            @Result(property = "loginArea", column = "login_area"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "loginTime", column = "login_time") })
    @SelectProvider(type = LoginLogSelectProvider.class, method = "query")
    List<LoginLog> query(Object object);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = MAPPER_NAMESPACE
                                                                                                      + "UserMapper.get")),
            @Result(property = "loginArea", column = "login_area"),
            @Result(property = "ip", column = "ip"),
            @Result(property = "loginTime", column = "login_time") })
    @Select("select * from login_log where id=#{id}")
    LoginLog get(Serializable id);

    class LoginLogSelectProvider {
        public String query(LoginLogQuery query) {
            SQL sql = new SQL() {
                {
                    SELECT("*");
                    FROM("login_log l");
                }
            };
            appendWhereClause(sql, query);
            return sql.toString();
        }

        private void appendWhereClause(SQL sql, LoginLogQuery query) {
            if (null == query) {
                return;
            }

            if (null != query.getUserId()) {
                sql.WHERE("userId=#{userId}");
            }

            if (!StringUtils.isEmpty(query.getIp())) {
                sql.WHERE("ip=#{ip}");
            }
        }

    }
}
