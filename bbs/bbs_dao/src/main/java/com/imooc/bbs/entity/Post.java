package com.imooc.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Post {
    private int id;//帖子编号
    private String username;//用户名
    private String title;//帖子标题
    private String category;//帖子分类
    private String content;//帖子内容
    private String tag;//帖子标签
    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date createTime;//帖子创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
