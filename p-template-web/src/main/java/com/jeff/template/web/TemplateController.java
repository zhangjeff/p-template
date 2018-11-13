package com.jeff.template.web;


import com.jeff.template.api.IOrderService;
import com.jeff.template.api.IUserService;
import com.jeff.template.model.base.Order;
import com.jeff.template.model.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class TemplateController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET ,value = "/user/search")
    public List search() {
            List<User> userList = userService.queryUserList();
        return userList;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST ,value = "/insertUser")
    public String createUser() {
        User user = new User();
        user.setUserId(1111);
        user.setUserName("张三");
        user.setCreateDate(new Date());
        int i =  userService.insert(user);
        return "insertUser " + i;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST ,value = "/insertOrder")
    public String createOrder() {
        Order order = new Order();
        order.setCreateDate(new Date());
        order.setSerialNumber(UUID.randomUUID().toString());
        order.setMarketId("11111");
        order.setShopId("99999");
        order.setShardingKey(order.getMarketId() + "-" + order.getShopId());
        order.setId(123467L);
        int i = orderService.insertOrder(order);
        return "insertOrder" + i;
    }
}
