package com.buyou.order.controller;

import com.buyou.order.service.OrderIndexService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author evan
 * create date 2019/8/30
 */
@RestController
public class OrderQueryController {

    private final OrderIndexService orderIndexService;

    public OrderQueryController(OrderIndexService orderIndexService) {
        this.orderIndexService = orderIndexService;
    }

    @GetMapping("/q")
    public String ok(){
        orderIndexService.save(null);
        return "OK";
    }
}
