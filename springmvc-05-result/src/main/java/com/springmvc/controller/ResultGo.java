package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 通过设置 Servlet API，不需要视图解析器
@Controller
public class ResultGo {
    // 通过 HttpServletResponse 进行输出
    @RequestMapping("/result/test1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello, Spring By Servlet API");
    }

    // 通过 HttpServletResponse 实现重定向
    @RequestMapping("/result/test2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }

    // 通过 HttpServletResponse 实现转发
    @RequestMapping("/result/test3")
    public void test3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("msg", "转发");
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
    }
}
