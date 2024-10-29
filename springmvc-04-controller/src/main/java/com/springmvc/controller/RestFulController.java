package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 代表这个类会被 Spring 接管
// 被这个注解的类中的所有方法，如果返回值是 String，并且有具体页面可以跳转，那么就会被视图解析器解析
@Controller
public class RestFulController {
    // 映射访问路径
    @RequestMapping("/commit/{p1}/{p2}")
    // 使用 @PathVariable 注解，让方法参数的值对应绑定到一个 URI 模板变量上
    // 通过路径变量的类型可以约束访问参数，如果类型不一样，则访问不到对应的请求方法
    public String index(@PathVariable int p1, @PathVariable int p2, Model model) {
        int result = p1 + p2;
        model.addAttribute("msg", "结果：" + result);
        return "hello";
    }

    // 映射访问路径，必须是 POST 请求
    // 方法级别的注解变体有如下几个： 组合注解
    // @GetMapping 它所扮演的是 @RequestMapping(method =RequestMethod.GET) 的一个快捷方式
    // @PostMapping
    // @PutMapping
    // @DeleteMapping
    // @PatchMapping
    @RequestMapping(value = "/hello", method = {RequestMethod.POST})
    public String index2(Model model) {
        model.addAttribute("msg", "使用 method 属性执行请求类型");
        return "hello";
    }
}
