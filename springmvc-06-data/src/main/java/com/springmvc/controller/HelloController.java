package com.springmvc.controller;

import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    // 提交的域名称和处理方法的参数名一致 ?name=xxx
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println(name);
        return "hello";
    }

    // 提交的域名称和处理方法的参数名不一致 ?username=xxx
    @RequestMapping("/hello/v2")
    public String hello2(@RequestParam("username") String name) {
        System.out.println(name);
        return "hello";
    }

    // 提交的是一个对象，要求提交的表单域和对象的属性名一致，参数使用对象即可
    @RequestMapping("/hello/v3")
    public String hello2(User user) {
        System.out.println(user);
        return "hello";
    }
}
