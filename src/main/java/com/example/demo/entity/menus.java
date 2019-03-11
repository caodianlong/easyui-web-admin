package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class menus {
    private String id;
    private String title;
    private String iconCls;
    private List<SubMenu> children;
}
