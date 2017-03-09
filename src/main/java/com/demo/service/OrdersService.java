package com.demo.service;

import com.demo.domain.Orders;
import org.springframework.data.domain.Page;

/**
 * Created by 海峰 on 2017/3/8.
 */
public interface OrdersService {

    public void addOrders(Orders orders);

    public void deleteOrders(Orders orders);

    public void updateOrders(Orders orders);

    public Orders getOrders(Long id);

    public Page<Orders> getOrdersList(int pageNum,int pageSize);

}
