package com.demo.service;

import com.demo.domain.Product;
import org.springframework.data.domain.Page;

/**
 * Created by 海峰 on 2017/3/6.
 */
public interface ProductService {

    public void addProduct(Product product);

    public void updateProduct(Product product);

    public void setSale(Product product);

    public void setNotSale(Product product);

    public Product findProduct(Long id);

    public Page<Product> findByPage(int pageNum, int pageSize);


}
