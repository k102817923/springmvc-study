package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

    @RequestMapping("/interceptor/test1")
    public String interceptor1() {
        System.out.println("interceptor...");
        return "index";
    }

}
