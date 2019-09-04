package com.buyou.order.controller;

import com.buyou.order.entity.OrderIndex;
import com.buyou.order.service.OrderIndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author evan
 * create date 2019/8/30
 */
@RestController
public class OrderQueryController {

    private final OrderIndexService orderIndexService;

    /**
     *
     * @param orderIndexService
     */
    public OrderQueryController(OrderIndexService orderIndexService) {
        this.orderIndexService = orderIndexService;
    }


    /**
     *
     * @return
     */
    @GetMapping("/q")
    public String ok(){
        orderIndexService.save(null);
        return "OK";
    }

    /**
     *
     *
     * @return
     */
    @GetMapping("/s")
    public List<OrderIndex> search(){
        return  orderIndexService.search();
    }


}
