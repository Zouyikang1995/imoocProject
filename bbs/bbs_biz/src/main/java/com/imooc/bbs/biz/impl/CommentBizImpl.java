package com.imooc.bbs.biz.impl;

import com.imooc.bbs.biz.CommentBiz;
import com.imooc.bbs.dao.CommentDao;
import com.imooc.bbs.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("commentBiz")
public class CommentBizImpl implements CommentBiz {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Comment comment) {
        comment.setCreateTime(new Date());
        commentDao.insert(comment);
    }

    @Override
    public List<Comment> getByPostId(int id) {
        return commentDao.selectByPostId(id);
    }
}
