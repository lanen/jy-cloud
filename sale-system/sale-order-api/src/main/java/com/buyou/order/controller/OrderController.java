package com.buyou.order.controller;

import com.buyou.order.feign.OrderApi;
import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import com.buyou.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    /**
     *
     */
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     *
     * @param createParam
     * @return
     */
    @PostMapping("/order")
    public OrderDto createOrder(@RequestBody OrderCreateParam createParam){
        OrderDto dto = new OrderDto();
        dto.setOrderId(System.currentTimeMillis());
        return dto;
    }


}
