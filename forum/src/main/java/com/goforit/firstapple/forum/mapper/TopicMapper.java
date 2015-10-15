package com.goforit.firstapple.forum.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.goforit.firstapple.forum.model.Topic;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.TopicQuery;

@Repository
public interface TopicMapper extends BaseMapper{
    
    String INSERT="insert into topic(board_id,topic_title,user_id,view_num,post_num,last_post_time,created_time,modified_time) "+
    "values(#{boardId},#{topicTitle},#{userId},#{viewNum},#{postNum},now(),now(),now())";
    
    String UPDATE="update topic set board_id=#{boardId},topic_title=#{topicTitle},user_id=#{userId},"+
    "view_num=#{viewNum},post_num=#{postNum},last_post_time=#{lastPostTime},modified_time=now() where id=#{id}";
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="boardId",column="board_id"),
        @Result(property="topicTitle",column="topic_title"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get")),
        @Result(property="viewNum",column="view_num"),
        @Result(property="postNum",column="post_num"),
        @Result(property="lastPostTime",column="last_post_time"),
        @Result(property="createdTime",column="created_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @Select("select * from topic where id=#{id}")
    Topic get(Serializable id);
    
    @Delete("delete from topic where id=#{id}")
    int delete(Serializable id);
    
    @Insert(INSERT)
    @Options(keyProperty="id",useGeneratedKeys=true,flushCache=true)
    int insert(Topic topic);
    
    @Update(UPDATE)
    @Options(useCache=true,flushCache=true)
    int update(Topic topic);
    
    
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="boardId",column="board_id"),
        @Result(property="topicTitle",column="topic_title"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get")),
        @Result(property="viewNum",column="view_num"),
        @Result(property="postNum",column="post_num"),
        @Result(property="lastPostTime",column="last_post_time"),
        @Result(property="createdTime",column="created_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @SelectProvider(type=TopicProvider.class,method="query")
    List<Topic> query(Object params);
    
    class TopicProvider{
        public String query(TopicQuery query){
            SQL sql=new SQL(){
                {
                    SELECT("*");
                    FROM("topic t");
                }
            };
            
            appendWhereClause(sql, query);
            return sql.toString();
        }
        
        private void appendWhereClause(SQL sql,TopicQuery query){
            if( null == query){
                return ;
            }
            
            if( !StringUtils.isEmpty(query.getTopicTitle())){
                sql.WHERE("topic_title=#{topicTitle}");
            }
            
            if( -1!=query.getUserId()){
                sql.WHERE("user_id=#{userId}");
            }
        }
        
        
    }
    
    
}
