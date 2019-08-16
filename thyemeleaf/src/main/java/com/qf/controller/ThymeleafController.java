package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @RequestMapping("demoOne")
    public String thymeleafDemoOne(Model model) {
        model.addAttribute("message", "许可笑得很慈祥");
        return "helloworld";
    }
}
