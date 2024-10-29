package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

    @RequestMapping("/ajax/test1")
    public String ajax1(String name, String pwd) {
        String msg = "";

        if (name != null) {
            if ("root".equals(name)) {
                msg = "OK";
            } else {
                msg = "ERROR";
            }
        }

        if (pwd != null) {
            if ("root".equals(pwd)) {
                msg = "OK";
            } else {
                msg = "ERROR";
            }
        }

        return msg;
    }

}
