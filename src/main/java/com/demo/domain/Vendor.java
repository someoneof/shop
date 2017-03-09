package com.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Entity
@ToString
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long venid;

    @Column(nullable = false,length = 20)
    private String verName;

    @Column(nullable = false,length = 20)
    private String verAddress;

    @Column(nullable = false,length = 15)
    private String verCountry;

    @OneToMany(cascade = {CascadeType.REFRESH},mappedBy = "vendor")
    private Set<Product> products=new HashSet<>();

    public void addProduct(Product product){
        if(!products.contains(product)){
            this.products.add(product);
            product.setVendor(this);
        }
    }
}
