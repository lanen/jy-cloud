package com.buyou.order.feign;

import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 */
public interface OrderApi {

    @PostMapping("/order")
    OrderDto createOrder(@RequestBody OrderCreateParam createParam);
}
