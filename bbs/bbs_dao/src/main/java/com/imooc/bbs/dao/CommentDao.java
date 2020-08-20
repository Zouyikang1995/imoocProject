package com.imooc.bbs.dao;

import com.imooc.bbs.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public interface CommentDao {
    void insert(Comment comment);
    //通过postId来删除评论
    void deleteByPostId(int postId);
    //通过postId来查找评论
    List<Comment> selectByPostId(int postId);
}
