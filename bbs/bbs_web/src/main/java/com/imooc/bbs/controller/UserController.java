package com.imooc.bbs.controller;

import com.imooc.bbs.biz.UserBiz;
import com.imooc.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("userControllelr")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("users", userBiz.getAll());
        return "pages/users";
    }

    @RequestMapping(value = "/disable",params = "id")
    public String disable(int id, Map<String, Object> map) {
        userBiz.disable(id);
        map.put("users", userBiz.getAll());
        return "pages/users";
    }

    @RequestMapping(value = "/lock",params = "id")
    public String lock(int id, Map<String, Object> map) {
        userBiz.lock(id);
        map.put("users", userBiz.getAll());
        return "pages/users";
    }

    @RequestMapping(value = "/normal",params = "id")
    public String normal(int id, Map<String, Object> map) {
        userBiz.normal(id);
        map.put("users", userBiz.getAll());
        return "pages/users";
    }

}
