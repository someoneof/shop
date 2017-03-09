package com.demo.domain;

import com.demo.domain.supportBean.BuyItem;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 海峰 on 2017/3/8.
 */
@Data
@ToString
public class BuyCart {

    private List<BuyItem> items=new ArrayList<>();

    private Float totalPrice=0f;

    public void addBuyItem(BuyItem buyItem){
        if(!items.contains(buyItem)) {
            items.add(buyItem);
        }
        else {
            for(BuyItem it:items){
                if(it.equals(buyItem))
                    it.setCount(it.getCount()+1);
                break;
            }
        }
    }

    public Float getTotalPrice(){
        Float totalPrice=0f;
        for(BuyItem buyItem:items){
            totalPrice+=buyItem.getProduct().getProductPrice()*buyItem.getCount();
        }
        return totalPrice;
    }

}
