package com.demo;


import com.demo.domain.Product;
import com.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 海峰 on 2017/3/6.6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductTest {

    @Autowired
    private ProductService productService;

    @Test
    public void save(){
        Product product=new Product();
        product.setProductName("西班牙AB Kolicare液体益生菌·安比宝");
        product.setProductDesc("缓解婴儿肠绞痛\n" +
                "减少婴儿过度啼哭\n" +
                "提高婴儿睡眠质量");
        product.setProductPrice(289f);
        product.setImagePath("images\\comm\\ABKolicare.png");
        product.setPricePath("images\\comm\\238.png");

        Product product1=new Product();
        product1.setProductName("美国Nature's Nutra铁元素营养液·莱思纽卡");
        product1.setProductDesc("预防贫血\n" +
                "促进食欲\n" +
                "维护智力");
        product1.setProductPrice(289f);
        product1.setImagePath("images\\comm\\ABKolicare.png");
        product1.setPricePath("images\\comm\\239.png");

        Product product2=new Product();
        product2.setProductName("丹麦Chr.Hansen科汉森BB-12液体益生菌");
        product2.setProductDesc("婴幼儿腹泻风险降低46%\n" +
                "便秘天数减少114%\n" +
                "呼吸道感染率降低31%");
        product2.setProductPrice(239f);
        product2.setImagePath("images\\comm\\Chr.Hansen.png");
        product2.setPricePath("images\\comm\\239.png");

        Product product3=new Product();
        product3.setProductName("美国Nature's Nutra铁元素营养液·莱思纽卡");
        product3.setProductDesc("预防贫血\n" +
                "促进食欲\n" +
                "维护智力");
        product3.setProductPrice(218f);
        product3.setImagePath("images\\comm\\Nature's Nutra.png");
        product3.setPricePath("images\\comm\\208.png");

        Product product4=new Product();
        product4.setProductName("澳大利亚Slaite DHA藻油·新西特");
        product4.setProductDesc("促进胎儿大脑发育\n" +
                "促进婴儿智力成长\n" +
                "减少新妈妈产后抑郁");
        product4.setProductPrice(238f);
        product4.setImagePath("images\\comm\\slaite.png");
        product4.setPricePath("images\\comm\\238.png");


        productService.addProduct(product);
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);
    }

    @Test
    public void findByPage(){
        Page<Product> page=productService.findByPage(2,3);
     /*   for(Product product:page.getContent())
            log.info(product.toString());*/
        System.out.println(page.getNumber());
    }

}
