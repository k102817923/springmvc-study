package com.springmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springmvc.pojo.User;
import com.springmvc.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 在类上直接使用 @RestController，所有的方法都只会返回 json 字符串了，不用再为每一个方法都添加 @ResponseBody
@RestController
public class UserController2 {

    @RequestMapping("/json/test3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "王五wangwu", "123456");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/json/test4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user1 = new User(1, "张三zhangsan", "123456");
        User user2 = new User(2, "李四lisi", "123456");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        return mapper.writeValueAsString(userList);
    }

    @RequestMapping("/json/test5")
    public String json5() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        // 默认日期格式会变成一个数字，是 1970 年 1 月 1 日到当前日期的毫秒数
        // jackson 默认会把时间转成 timestamps 形式
        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/json/test6")
    public String json6() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();

        // 不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 指定日期格式
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/json/test7")
    public String json7() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.toJson(date);
    }

}
