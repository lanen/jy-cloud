package com.buyou.page.controller;

import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import com.buyou.page.OrderClient;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final OrderClient orderClient;

    public PageController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }


    @GetMapping("/order")
    public String orderPage(Model model){

        OrderDto order = orderClient.createOrder(new OrderCreateParam());
        model.addAttribute("order", order);
        return "order";
    }
}
