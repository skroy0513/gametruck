package com.gametruck.web.form;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SignupForm {

    private String id;
    private String password;
    private String email;
}
