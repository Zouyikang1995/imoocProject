package com.imooc.bbs.controller;

import com.imooc.bbs.biz.PostBiz;
import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.entity.Post;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller("globalController")
public class GlobalController {
    @Autowired
    private PostBiz postBiz;
    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        User user = userBiz.login(username, password);
        if (null == user) {
            return "redirect:to_login";
        }
        session.setAttribute("user", user);
        return "redirect:list";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:list";
    }

    @RequestMapping("/to_register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user, @RequestParam(value = "password_confirm") String passwordConfirm) {
        System.out.println(user.getUsername());
        if (user.getPassword().equals(passwordConfirm)) {
            userBiz.register(user);
            return "redirect:to_login";
        } else {
            return "redirect:to_register";
        }
    }

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        List<Post> posts = postBiz.getAll();
        map.put("posts", posts);
        return "list";
    }
}
