package com.gametruck.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "page/home";
    }

    @GetMapping("/login")
    public String login() {
        return "page/login";
    }
}
