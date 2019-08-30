package com.buyou.order.controller;

import com.buyou.order.entity.OrderEntity;
import com.buyou.order.feign.OrderApi;
import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import com.buyou.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author evan
 */
@RestController
public class OrderController implements OrderApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     *
     */
    private final OrderService orderService;


    /**
     *
     * @param orderService
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     *
     * @param createParam Order Crate Param
     * @return
     */
    @PostMapping("/order")
    public OrderDto createOrder(OrderCreateParam createParam){

        OrderEntity order = orderService.createOrder(createParam);

        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getOrderId());

        return dto;
    }


    /**
     *
     * @param orderId
     * @return
     */
    @GetMapping("/order/{orderId}")
    public OrderDto findOrder(Long orderId){
        OrderDto dto = new OrderDto();
        return dto;
    }


    @GetMapping("/test")
    public void d(){
        throw new RuntimeException("ddd");
    }


}
