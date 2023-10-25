package com.gametruck.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {

    private int no;
    private Category category;
    private Platform platform;
    private String name;
    private String description;
    private int price;
    private int discountRate;
    private boolean onSell;
    private int stock;
    private Date createdDate;
    private Date updatedDate;
    private String cover;
}
