package com.demo.repository;

import com.demo.domain.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by 海峰 on 2017/3/7.
 */
@Repository
public interface OtderItemCrudRepository extends CrudRepository<OrderItem,Long>{

    public Page<OrderItem> findAll(Pageable pageable);
}
