package com.imooc.bbs.controller;

import com.imooc.bbs.biz.CommentBiz;
import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.entity.Comment;
import com.imooc.bbs.entity.Post;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("postController")
public class PostController {

    @Autowired
    private PostBiz postBiz;
    @Autowired
    private CommentBiz commentBiz;

    @RequestMapping("/posts/list")
    public String list(Map<String, Object> map) {
        map.put("posts", postBiz.getAll());
        return "pages/posts";
    }

    @RequestMapping(value = "/posts/remove", params = "id")
    public String remove(int id, Map<String, Object> map) {
        postBiz.remove(id);
        map.put("posts", postBiz.getAll());
        return "pages/posts";
    }

    @RequestMapping(value = "/detail", params = "id")
    public String detail(int id, Map<String, Object> map) {
        map.put("post", postBiz.get(id));
        map.put("comments",commentBiz.getByPostId(id));
        return "post";
    }

    @RequestMapping(value = "/addComment")
    public String addComment(HttpSession session, @RequestParam int id, @RequestParam String content) {
        Comment comment = new Comment();
        comment.setPostId(id);
        comment.setContent(content);
        User user = (User) session.getAttribute("user");
        comment.setUserId(user.getId());
        comment.setUsername(user.getUsername());
        commentBiz.add(comment);
        return "redirect:detail?id=" + id;
    }

    @RequestMapping("/to_post")
    public String toPost() {
        return "newpost";
    }

    @RequestMapping("/post")
    public String post(HttpSession session, Post post) {
        User user = (User) session.getAttribute("user");
        post.setUsername(user.getUsername());
        postBiz.add(post);
        return "redirect:list";
    }
}
