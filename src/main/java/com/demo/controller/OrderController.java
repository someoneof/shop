package com.demo.controller;

import com.demo.domain.Orders;
import com.demo.service.OrderItemService;
import com.demo.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 海峰 on 2017/3/9.
 */
@Controller
@Slf4j
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/order")
    public String setOrderContactInfo(ModelMap modelMap,Orders orders){
        log.info("orders:"+orders.toString());
        modelMap.put("orders",orders);
        return "order";
    }
}
