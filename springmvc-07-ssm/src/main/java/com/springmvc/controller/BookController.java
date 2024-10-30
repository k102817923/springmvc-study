package com.springmvc.controller;

import com.springmvc.pojo.Books;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class BookController {

    // Controller 层调 Service 层
//    @Autowired
//    @Qualifier("bookServiceImpl")
//    private BookService bookService;

    private final BookService bookService;

    // 不建议使用字段注入，改用构造函数注入
    @Autowired
    public BookController(@Qualifier("bookServiceImpl") BookService bookService) {
        this.bookService = bookService;
    }

    // 1.Spring 容器启动：应用启动时，Spring 容器会扫描项目中的所有 @Controller、@Service、@Repository 等注解的类，并注册为 Bean
    // 2.依赖注入：在 Spring 容器完成扫描并创建 Bean 的过程中，会按照构造函数或字段注入（基于 Bean 的配置）为 BookController 注入 BookService 实例（即 bookServiceImpl）
    // 3.完成初始化：Spring 容器完成 BookController 的实例化与依赖注入后，该控制器就会进入就绪状态，等待处理用户请求
    // 4.请求到来时：当有 HTTP 请求匹配到 /book/queryAll 路径时，SpringMVC 会调用该路径绑定的方法 queryAll，并将请求传递给这个 BookController 实例

    @RequestMapping("/book/queryAll")
    public String queryAll(Model model) {
        List<Books> books = bookService.queryAll();
        model.addAttribute("books", books);
        return "queryAll";
    }

}
