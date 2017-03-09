package com.demo.repository;

import com.demo.domain.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by 海峰 on 2017/3/8.
 */
@Repository
public interface OrdersCrudRepository extends CrudRepository<Orders,Long>{
    public Page<Orders> findAll(Pageable pageable);
}
