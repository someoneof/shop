package com.demo.service;

import com.demo.domain.Customer;

/**
 * Created by 海峰 on 2017/3/7.
 */
public interface CustomerService {

    public void addCustomer(Customer customer);

    public Customer getCustomer(String nickName);
}
