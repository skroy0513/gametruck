package com.gametruck.security.user;

import com.gametruck.vo.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class LoginUser {

    private String id;
    private String password;
    private String email;
    private String name;
    private String rolename;

    public LoginUser() {}

    public LoginUser(User user){
        super();
        this.id = user.getId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.rolename = user.getRoleName();
    }

    public String getRealname(){
        return name;
    }
}
