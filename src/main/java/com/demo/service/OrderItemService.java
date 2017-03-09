package com.demo.service;

import com.demo.domain.OrderItem;
import org.springframework.data.domain.Page;

/**
 * Created by 海峰 on 2017/3/7.
 */
public interface OrderItemService {

    public void addOrderItem(OrderItem orderItem);

    public void deleteOrderItem(OrderItem orderItem);

    public void updateOrderItem(OrderItem orderItem);

    public OrderItem getOrderItem(Long id);

    public Page<OrderItem> getOrderItemlist(int pageNum,int pageSize);
}
