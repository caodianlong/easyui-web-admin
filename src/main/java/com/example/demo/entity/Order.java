package com.example.demo.entity;

import lombok.Data;

@Data
public class Order {
    private String productid;
    private String productname;
    private String unitcost;
    private String status;
    private String listprice;
    private String attr1;
    private String itemid;
}
