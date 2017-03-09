package com.demo.service.impl;

import com.demo.domain.OrderItem;
import com.demo.repository.OtderItemCrudRepository;
import com.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/7.
 */
@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OtderItemCrudRepository otderItemCrudRepository;
    @Override
    public void addOrderItem(OrderItem orderItem) {
        otderItemCrudRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItem(OrderItem orderItem) {
        otderItemCrudRepository.delete(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        otderItemCrudRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        return otderItemCrudRepository.findOne(id);
    }

    @Override
    public Page<OrderItem> getOrderItemlist(int pageNum, int pageSize) {
        return otderItemCrudRepository.findAll(new PageRequest(pageNum,pageSize));
    }
}
