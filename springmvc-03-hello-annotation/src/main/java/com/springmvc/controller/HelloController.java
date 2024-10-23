package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 为了让 Spring IOC 容器初始化时自动扫描到
@Controller
// 为了映射请求路径
@RequestMapping("/hello")
public class HelloController {
    // 真实访问地址：localhost:8080/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model) {
        // 封装数据
        model.addAttribute("msg", "Hello SpringMVC");
        // return 的结果会被视图解析器处理，等价于 WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
