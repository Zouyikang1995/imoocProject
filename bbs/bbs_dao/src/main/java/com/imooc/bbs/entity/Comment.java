package com.imooc.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private int id;//编号
    private int userId;//回复用户id
    private String username;//回复用户名
    private String content;//回复内容
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date createTime;//回复时间
    private int postId;//对应的帖子id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
