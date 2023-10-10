package com.gametruck.security.service;

import com.gametruck.mapper.UserMapper;
import com.gametruck.security.user.CustomUserDetails;
import com.gametruck.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User savedUser = userMapper.getUserById(username);
        if (savedUser == null) {
            throw new UsernameNotFoundException("사용자 정보를 찾을 수 없습니다.");
        }
        CustomUserDetails user = new CustomUserDetails(savedUser);

        return user;
    }
}
