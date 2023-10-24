package com.gametruck.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String home() {
        return "page/admin/home";
    }

    @GetMapping("/form")
    public String form() {
        return "page/admin/form";
    }
}
