package com.imooc.bbs.biz;

import com.imooc.bbs.entity.Post;

import java.util.List;

public interface PostBiz {
    void add(Post post);
    void remove(int id);
    Post get(int id);
    List<Post> getAll();
}
