package com.example.demo.service;


import com.example.demo.entity.Order;
import com.example.demo.dao.OrderDao;
import com.example.demo.entity.DataGridRespond;
import com.example.demo.entity.menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private OrderDao orderDao;


    @RequestMapping("/getDemoData")
    public String getDemoData() {

        return "{\"total\":28,\"rows\":[\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":\"10.00\",\"status\":\"P\",\"listprice\":\"36.50\",\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"18.50\",\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"38.50\",\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"26.50\",\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"35.50\",\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"158.50\",\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"83.50\",\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"23.50\",\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":\"12.00\",\"status\":\"P\",\"listprice\":\"89.50\",\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},\n" +
                "\t{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":\"92.00\",\"status\":\"P\",\"listprice\":\"63.50\",\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"},\n" +
                "    {\"productid\":\"DL-SW-01\",\"productname\":\"Dream\",\"unitcost\":\"10.00\",\"status\":\"P\",\"listprice\":\"99.9\",\"attr1\":\"Large\",\"itemid\":\"EST-19\"}\n" +
                "]}\n";

    }

    @RequestMapping("/queryDemoData")
    public DataGridRespond queryDemoData() {
        List<Order> data = orderDao.getOrders();
        DataGridRespond result = new DataGridRespond();
        result.setTotal(data.size());
        result.setRows(data);
        return result;
    }

    @RequestMapping("/queryMenus")
    public List<menus> queryMenus() {
        //从数据库读取菜单
        //创建应答对象
        return null;
    }

}
