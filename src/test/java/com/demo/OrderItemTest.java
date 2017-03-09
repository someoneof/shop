package com.demo;

import com.demo.domain.OrderItem;
import com.demo.domain.Orders;
import com.demo.service.OrderItemService;
import com.demo.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 海峰 on 2017/3/9.
 */@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderItemTest {

     @Autowired
     OrderItemService orderItemService;

     @Autowired
    OrdersService ordersService;

     @Test
     public void save(){
         OrderItem orderItem=new OrderItem();
         orderItem.setQuantity(1);
         orderItem.setItemPrice(1f);
         orderItem.setProductId(1L);
         orderItemService.addOrderItem(orderItem);
     }

    @Test
    public void saveOrder(){
        Orders orders = new Orders();
        Set<OrderItem> items= new HashSet<OrderItem>();
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(1);
        orderItem.setItemPrice(1f);
        orderItem.setProductId(1L);
        orderItem.setOrder(orders);
        items.add(orderItem);
        orders.setOrderItems(items);
        ordersService.addOrders(orders);
        orderItemService.addOrderItem(orderItem);
    }
}
