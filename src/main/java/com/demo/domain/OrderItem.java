package com.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Entity
@Data
@ToString
public class OrderItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Integer quantity=0;

    @Column(nullable = false)
    private Float itemPrice;

    @ManyToOne(cascade ={CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "orderId")
    private Orders order;
}
