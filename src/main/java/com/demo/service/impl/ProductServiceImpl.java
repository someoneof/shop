package com.demo.service.impl;

import com.demo.domain.Product;
import com.demo.repository.ProductCrudRepository;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public void addProduct(Product product) {
        this.productCrudRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productCrudRepository.save(product);
    }


    @Override
    public void setSale(Product product) {
        product.setVisible(true);
        this.productCrudRepository.save(product);
    }

    @Override
    public void setNotSale(Product product) {
        product.setVisible(false);
        this.productCrudRepository.save(product);
    }

    @Override
    public Product findProduct(Long id) {
        return (Product) this.productCrudRepository.findOne(id);
    }


    @Override
    public Page<Product> findByPage(int pageNum,int pageSize) {
        return this.productCrudRepository.findAll(new PageRequest(pageNum,pageSize));
    }

}
