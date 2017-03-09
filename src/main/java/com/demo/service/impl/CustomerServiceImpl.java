package com.demo.service.impl;

import com.demo.domain.Customer;
import com.demo.repository.CustomerCrudRepository;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/7.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerCrudRepository customerCrudRepository;
    @Override
    public void addCustomer(Customer customer) {
        customerCrudRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String nickName) {
        return customerCrudRepository.findByNickName(nickName);
    }

}
