package com.demo.repository;

import com.demo.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by 海峰 on 2017/3/6.
 */
@Repository
public interface ProductCrudRepository extends CrudRepository<Product,Long> {

    public Page<Product> findAll(Pageable pageable);
}
