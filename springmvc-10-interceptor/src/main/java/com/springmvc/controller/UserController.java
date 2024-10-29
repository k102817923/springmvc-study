package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    // 跳转到登陆页面
    @RequestMapping("/user/jumplogin")
    public String jumpLogin() {
        return "login";
    }

    // 跳转到成功页面
    @RequestMapping("/user/jumpSuccess")
    public String jumpSuccess() {
        return "success";
    }

    // 登陆提交
    @RequestMapping("/user/login")
    public String login(HttpSession session, String username, String pwd) {
        // 向 Session 记录用户身份信息
        System.out.println("username：" + username + "pwd：" + pwd);
        session.setAttribute("user", username);
        session.setAttribute("pwd", pwd);
        return "success";
    }

    // 退出登陆
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        // Session 过期
        session.invalidate();
        return "login";
    }

}
