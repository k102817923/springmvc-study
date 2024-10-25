package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {
    @RequestMapping("/encoding/test")
    public String test(Model model, String name) {
        model.addAttribute("msg", name);
        return "hello";
    }
}
