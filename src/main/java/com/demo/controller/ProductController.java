package com.demo.controller;

import com.demo.domain.Product;
import com.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 海峰 on 2017/3/7.
 */
@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String productList(ModelMap modelMap,Integer pageNum){
        if(pageNum==null) pageNum=1;
        log.info("pageNum:"+pageNum);
        modelMap.put("page",productService.findByPage(pageNum,6));
        return "index";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String edit(Product product){
        log.info("edit:"+product.toString());
        try{
            productService.updateProduct(product);
            return "修改成功!";
        }catch (Exception e){
            return "修改失败!";
        }
    }

    @RequestMapping("/productedit")
    public String editUI(Long id,ModelMap modelMap){
        modelMap.put("product",productService.findProduct(id));
        return "editUI";
    }

    @PutMapping("/product/{ids}/{methodName}")
    @ResponseBody
    public String setProductVisible(@PathVariable Long ids[],@PathVariable String methodName){
        log.info("产品修改上架下架操作 methodName:"+methodName);
        try {
            if (methodName.equals("sale"))
                for (Long i : ids)
                    productService.setSale(productService.findProduct(i));
            else
                for (Long i : ids)
                    productService.setNotSale(productService.findProduct(i));
            return "操作成功!";
        } catch (Exception e) {
            return "操作失败!";
        }
    }


    @GetMapping("/product/{productId}")
    public String productDetails(@PathVariable Long productId,ModelMap modelMap){
        modelMap.put("product",productService.findProduct(productId));
        log.info(productService.findProduct(productId).toString());
        return "pdetail";
    }

    @RequestMapping("/productlist")
    public String productManage(ModelMap modelMap,Integer pageNum){
        log.info("产品管理 pageNum:"+pageNum);
        if(pageNum==null || pageNum<=0) pageNum=1;
        Page<Product> page=productService.findByPage(pageNum-1,3);
        if(pageNum>page.getTotalPages()) pageNum=page.getTotalPages();
        modelMap.put("page",productService.findByPage(pageNum-1,3));
        return "productManage";
    }
}
