package com.buyou.order.controller;

import com.buyou.order.feign.OrderApi;
import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import com.buyou.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

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

    @GetMapping("/test")
    public void d(){
        throw new RuntimeException("ddd");
    }


}
