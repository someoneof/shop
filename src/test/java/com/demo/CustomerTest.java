package com.demo;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 海峰 on 2017/3/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CustomerTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setCname("xiaohong");
        customer.setNickName("xxxxx");
        customer.setCusAddress("xxxx");
        customer.setEmail("slsflk");
        customer.setPassword("sljfdkf");
        customer.setTel("234234");
        customerService.addCustomer(customer);
    }

    @Test
    @Transactional
    public void findByName() {
        Customer customer = customerService.getCustomer("xxxxx");
        System.out.print("-----------------"+customer.getOrders().iterator().next().getOrderId());
//        log.info(customer.getOrders().toString());
    }
}
