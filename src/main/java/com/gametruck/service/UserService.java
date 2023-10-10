package com.gametruck.service;

import com.gametruck.mapper.UserMapper;
import com.gametruck.vo.User;
import com.gametruck.web.form.SignupForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupForm signupForm) {
        System.out.println(signupForm.getPassword());
        User user = User.builder().id(signupForm.getId())
                .password(passwordEncoder.encode(signupForm.getPassword()))
                .email(signupForm.getEmail()).build();
        userMapper.createUser(user);
    }
}