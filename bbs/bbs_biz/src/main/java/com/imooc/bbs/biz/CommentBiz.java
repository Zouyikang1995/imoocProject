package com.imooc.bbs.biz;

import com.imooc.bbs.entity.Comment;

import java.util.List;

public interface CommentBiz {
    void add(Comment comment);
    List<Comment> getByPostId(int id);
}
