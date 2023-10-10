package com.gametruck.mapper;

import com.gametruck.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 신규 사용자 등록
    void createUser(User user);

    User getUserById(String username);
}
