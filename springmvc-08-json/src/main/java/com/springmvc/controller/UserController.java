package com.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    // @RequestMapping("/json/test1")
    // produces 指定响应体返回类型和编码
    @RequestMapping(path = "/json/test1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json() throws JsonProcessingException {
        // 创建一个 jackson 对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "张三zhangsan", "123456");
        // 将对象解析成 json 格式
        // ResponseBody 注解会将 str 转成 json 格式返回
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/json/test2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        // 创建一个 jackson 对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "李四lisi", "123456");
        // 将对象解析成 json 格式
        // ResponseBody 注解会将 str 转成 json 格式返回
        return mapper.writeValueAsString(user);
    }

}
