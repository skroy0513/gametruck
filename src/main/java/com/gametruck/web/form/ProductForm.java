package com.gametruck.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductForm {

    private int catNo;
    private int platformNo;
    private String name;
    private int price;
    private int discountRate;
    private int stock;
    private String description;
    private String cover;
}
