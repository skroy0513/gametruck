package com.gametruck.web.controller;

import com.gametruck.service.UserService;
import com.gametruck.web.form.SignupForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String singup(SignupForm signupForm) {
        userService.signup(signupForm);
        return "redirect:/";
    }

    @PostMapping("/user/signup")
    public String singupPage() {
        return "";
    }

    @PostMapping("/user/signin")
    public String singinPage(){
        return "";
    }
}
