package com.demo.domain.supportBean;

import java.io.Serializable;

/**
 * Created by 海峰 on 2017/3/6.
 */

public enum OrderState implements Serializable{

    CANCEL {public String getName(){return "订单已被取消";}},
    WAITCONFIRM {public String getName(){return "等待订单确认";}},
    WAITPAYMENT {public String getName(){return "未付款";}},
    ADMEASUREPRODUCT {public String getName(){return "已经付款";}},
    WAITDELIVER {public String getName(){return "等待配送";}},
    DELIVERED {public String getName(){return "配送中";}},
    RECEIVED {public String getName(){return "已经签收";}};

    public abstract String getName();
}
