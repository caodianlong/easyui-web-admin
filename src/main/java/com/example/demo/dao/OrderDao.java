package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDao {

    @Select("select productid,productname,unitcost,status,listprice,attr1,itemid from order")
    List<Order> getOrders();
}
