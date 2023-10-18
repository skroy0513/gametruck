package com.gametruck.security.service;

import com.gametruck.mapper.UserMapper;
import com.gametruck.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapperService {

    private final UserMapper userMapper;

    public User getUserById(String id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userMapper.getUserByEmail(email);
        return user;
    }
}
