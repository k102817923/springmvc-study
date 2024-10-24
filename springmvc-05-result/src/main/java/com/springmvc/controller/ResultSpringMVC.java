package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultSpringMVC {
    // 转发
    @RequestMapping("/resultMVC/test1")
    public String test1() {
        return "/test.jsp";
    }

    // 转发二
    @RequestMapping("/resultMVC/test2")
    public String test2() {
        return "forward:/test.jsp";
    }

    // 重定向
    @RequestMapping("/resultMVC/test3")
    public String test3() {
        return "redirect:/test.jsp";
    }
}
