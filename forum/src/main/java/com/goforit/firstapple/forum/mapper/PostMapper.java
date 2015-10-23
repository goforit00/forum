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

import com.goforit.firstapple.forum.model.Post;
import com.goforit.firstapple.forum.model.User;
import com.goforit.firstapple.forum.model.query.PostQuery;



@Repository
public interface PostMapper extends BaseMapper{
    
    String INSERT="insert into post(topic_id,user_id,post_seq_num,post_text,like_num,dislike_num,created_time,modified_time)"+
    " values(#{topicId},#{user.id},#{postSeqNum},#{postText},#{likeNum},#{dislikeNum},now(),now())";

    
    String UPDATE="update post set topic_id=#{topicId},user_id=#{user.id},post_seq_num=#{postSeqNum},"+
    "post_text=#{postText},like_num=#{likeNum},dislike_num=#{dislikeNum},modified_time=#{modifiedTime} where id=#{id}";

    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="topicId",column="topic_id"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get")),
        @Result(property="postSeqNum",column="post_seq_num"),
        @Result(property="postText",column="post_text"),
        @Result(property="likeNum",column="like_num"),
        @Result(property="dislikeNum",column="dislike_num"),
        @Result(property="createdTime",column="created_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @Select("select * from post where id=#{id}")
    Post get(Serializable id);
    
    @Insert(INSERT)
    @Options(useGeneratedKeys=true,flushCache=true,keyProperty="id")
    int insert(Post post);
    
    @Update(UPDATE)
    @Options(useCache=true,flushCache=true)
    int update(Post post);
    
    @Delete("delete from post where id=#{id}")
    int delete(Serializable id);
    
    
    
    @Results({
        @Result(property="id",column="id"),
        @Result(property="topicId",column="topic_id"),
        @Result(property="user",column="user_id",javaType=User.class,
        one=@One(select=MAPPER_NAMESPACE+"UserMapper.get")),
        @Result(property="postSeqNum",column="post_seq_num"),
        @Result(property="postText",column="post_text"),
        @Result(property="likeNum",column="like_num"),
        @Result(property="dislikeNum",column="dislike_num"),
        @Result(property="createdTime",column="created_time"),
        @Result(property="modifiedTime",column="modified_time")
    })
    @SelectProvider(type=PostProvider.class,method="query")
    List<Post> query(PostQuery query);
    
    
    class PostProvider{
        public String query(PostQuery query){
            SQL sql=new SQL(){
                {
                    SELECT("*");
                    FROM("post p");
                }
            };
            sql.WHERE("topic_id=#{topicId}");
            appendWhereClause(sql, query);
            return sql.toString();
            
        }
        
        private void appendWhereClause(SQL sql,PostQuery query){
            if(null==query){
                return ;
            }
            
            if(query.getPostSeqNum()>0){
                sql.WHERE("post_seq_num=#{postSeqNum}");
            }
        }
    }

}
