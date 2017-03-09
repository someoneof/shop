package com.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Entity
@ToString
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(nullable = false,length = 100)
    private String productName;

    @Column(nullable = false,length = 10)
    private Float productPrice;

    @Column
    private Boolean visible=true;

    @Column(length = 100)
    private String productDesc;

    private String imagePath;

    private Integer quantity;

    private String pricePath;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="venid")
    private Vendor vendor;

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
}
