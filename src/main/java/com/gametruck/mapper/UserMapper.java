package com.gametruck.mapper;

import com.gametruck.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 신규 사용자 등록
    void createUser(User user);

    // 아이디 가져오기
    User getUserById(String username);

    // 이메일 가져오기
    User getUserByEmail(String email);
}
