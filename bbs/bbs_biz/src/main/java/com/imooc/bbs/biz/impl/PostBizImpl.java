package com.imooc.bbs.biz.impl;

import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.dao.CommentDao;
import com.imooc.bbs.dao.PostDao;
import com.imooc.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("postBiz")
public class PostBizImpl implements PostBiz {

    @Autowired
    private PostDao postDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Post post) {
        //插入新的帖子时添加时间
        post.setCreateTime(new Date());
        postDao.insert(post);
    }

    @Override
    public void remove(int id) {
        postDao.delete(id);
        //删除帖子时需要删除所有相关的评论
        if (null != commentDao.selectByPostId(id)) {
            commentDao.deleteByPostId(id);
        }
    }

    @Override
    public Post get(int id) {
        return postDao.select(id);
    }

    @Override
    public List<Post> getAll() {
        return postDao.selectAll();
    }
}
