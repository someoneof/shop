package com.demo.controller;

import com.demo.domain.BuyCart;
import com.demo.domain.OrderItem;
import com.demo.domain.Orders;
import com.demo.domain.supportBean.BuyItem;
import com.demo.service.CustomerService;
import com.demo.service.OrderItemService;
import com.demo.service.OrdersService;
import com.demo.service.ProductService;
import com.demo.web.SiteSessionListener;
import com.demo.web.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 海峰 on 2017/3/9.
 */
@Controller
@Slf4j
public class BuyCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/buyCart")
    public String showCart(ModelMap modelMap,HttpServletRequest request, HttpServletResponse response){
        modelMap.put("buyCart",getBuyCart(request,response));
        return "cart";
    }

    @PostMapping("/buyCart")
    public String setOrder(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) {
        try {
            BuyCart buyCart = getBuyCart(request, response);
            Orders orders = new Orders();
            orders.setTotalPrice(buyCart.getTotalPrice());
            ordersService.addOrders(orders);
            for (BuyItem item : buyCart.getItems()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(item.getProduct().getProductId());
                orderItem.setItemPrice(item.getProduct().getProductPrice());
                orderItem.setQuantity(item.getCount());
                orderItem.setOrder(orders);
                orderItemService.addOrderItem(orderItem);
            }
            log.info("放入orders");
            modelMap.put("orders",orders);

            log.info("放入orders之后");
            return "order";
        } catch (Exception e) {
            log.info("抛出一场那个");
            return "order";
        }
    }
    @GetMapping("/buyCart/{id}")
    @ResponseBody
    public String addItem(@PathVariable Long id,HttpServletRequest request, HttpServletResponse response) {
        log.info("addItem   id:"+id);
        try {
            BuyCart buyCart = getBuyCart(request, response);
            BuyItem buyItem = new BuyItem();
            buyItem.setProduct(productService.findProduct(id));
            buyCart.addBuyItem(buyItem);
            return "添加成功";
        } catch (Exception e) {
            return "添加失败";
        }
    }
    /**
     * cookie中存储的就是sessionId
     * 开始购物，从session拿到cart。判断是否为null。
     但是这里判断分为两个：
     第一个判断:
     如果购物车为空,(但存在历史记录sessionID，那就访问用户以前的session)
     1)从HttpServletRequest得到cookies的集合。遍历集合，看有没有cartId(其实就是获得的sessionId)的cookie
     2)如果有这个cookie，那就判断这个cookie是否有值
     3)如果这个cookie有值，那就判断这个cookie的值中是否session
     4)如果有session，那继续判断是否有cart(购物车对象以cart存储)
     5)如果有cart,将这个cart放入当前会话中，并清除session引用,将新的内容 保存到cookie中
     第二个判断:
     第一个判断没有成立，意思是虽然没有购物车，但是并没有历史记录sessionId等。
     那么就执行这个判断。这里就是长些的new一个购物车。只是要将相应的seesionId存到cookie中就ok了。
     */
    private BuyCart getBuyCart(HttpServletRequest request, HttpServletResponse response) {
        BuyCart buyCart = (BuyCart) request.getSession().getAttribute("buycart");
        if (buyCart == null) {
            String sid = WebUtil.getCookieByName(request, "buyCartID");
            if (sid != null) {
                HttpSession session = SiteSessionListener.getSession(sid);
                if (session != null) {
                    buyCart = (BuyCart) session.getAttribute("buycart");
                    if (buyCart != null) {
                        SiteSessionListener.remove(sid);
                        request.getSession().setAttribute("buycart", buyCart);
                        WebUtil.addCookie(response, "buyCartID", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
                    }
                }
            }
        }
        if (buyCart == null) {
            buyCart = new BuyCart();
            request.getSession().setAttribute("buycart", buyCart);
            WebUtil.addCookie(response, "buyCartID", request.getSession().getId(), request.getSession().getMaxInactiveInterval());
        }
        return buyCart;
    }

    private BuyCart getBuyCart(HttpServletRequest request){
        return (BuyCart)request.getSession().getAttribute("buycart");
    }

}
