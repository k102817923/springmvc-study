package com.springmvc.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.springmvc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController3 {

    @RequestMapping("/json/test8")
    public void json8() {
        User user1 = new User(1, "张三zhangsan", "123456");
        User user2 = new User(2, "李四lisi", "123456");
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        // Java 对象 -> JSON 字符串
        String str1 = JSON.toJSONString(userList);
        System.out.println(str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println(str2);

        // JSON 字符串 -> Java 对象
        User u2 = JSON.parseObject(str2, User.class);
        System.out.println(u2);

        // Java 对象 -> Json 对象
        JSONObject jsonObject = (JSONObject) JSON.toJSON(user2);
        System.out.println(jsonObject.get("name"));
    }

}
