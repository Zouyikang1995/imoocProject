package com.imooc.bbs.dao;

import com.imooc.bbs.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public interface PostDao {
    void insert(Post post);
    Post select(int id);
    List<Post> selectAll();
    void delete(int id);
}
