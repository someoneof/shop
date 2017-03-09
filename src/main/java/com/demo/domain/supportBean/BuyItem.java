package com.demo.domain.supportBean;

import com.demo.domain.Product;
import lombok.Data;
import lombok.ToString;

/**
 * Created by 海峰 on 2017/3/8.
 */
@Data
@ToString
public class BuyItem {
    private Product product;
    private Integer count=1;

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final BuyItem other = (BuyItem) obj;
        if (product == null)
        {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        String buyitemid = product.hashCode()+"-";
        return buyitemid.hashCode();
    }
}
