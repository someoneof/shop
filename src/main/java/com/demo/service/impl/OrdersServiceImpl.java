package com.demo.service.impl;

import com.demo.domain.Orders;
import com.demo.repository.OrdersCrudRepository;
import com.demo.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/8.
 */
@Slf4j
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersCrudRepository ordersCrudRepository;
    @Override
    public void addOrders(Orders orders) {
        ordersCrudRepository.save(orders);
    }

    @Override
    public void deleteOrders(Orders orders) {
        ordersCrudRepository.delete(orders);
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersCrudRepository.save(orders);
    }

    @Override
    public Orders getOrders(Long id) {
        return ordersCrudRepository.findOne(id);
    }

    @Override
    public Page<Orders> getOrdersList(int pageNum, int pageSize) {
        return ordersCrudRepository.findAll(new PageRequest(pageNum,pageSize));
    }
}
