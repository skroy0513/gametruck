package com.gametruck.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class User {

    private String id;
    private String password;
    private String email;
    private String name;
    private String providerType;
    private String tel;
    private Integer addressPostcode;
    private String address;
    private String addressDetail;
    private boolean disabled;
    private String roleName;
    private Date createdDate;
    private Date updatedDate;
}

