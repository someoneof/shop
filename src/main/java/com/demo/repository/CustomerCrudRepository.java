package com.demo.repository;

import com.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 海峰 on 2017/3/7.
 */
@Repository
public interface CustomerCrudRepository extends CrudRepository<Customer,Long> {

    public Customer findByNickName(String nickName);
}
