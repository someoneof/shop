package com.demo.controller;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 海峰 on 2017/3/7.
 */
@Controller
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public String login(Customer customer){
        if(customer.getCustomerId()==null) {
            log.info("login=============customer:"+customer);
            return "login";
        }
        Customer customer1=customerService.getCustomer(customer.getNickName());
        if(customer.getPassword().equals(customer1.getPassword()))
            return "redirect:product";
        else return "login fail";
    }



    @PostMapping("/customer")
    public String register(Customer customer){
        if (customer.getNickName()==null && customer.getPassword()==null)
            return "register";
        try{
            customerService.addCustomer(customer);
            return "redirect:product";
        }catch (Exception e){
            return "register";
        }
    }



}
