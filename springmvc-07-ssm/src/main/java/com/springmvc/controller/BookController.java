package com.springmvc.controller;

import com.springmvc.pojo.Books;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model) {
        List<Books> books = bookService.queryAll();
        model.addAttribute("books", books);
        return "queryAll";
    }
}
