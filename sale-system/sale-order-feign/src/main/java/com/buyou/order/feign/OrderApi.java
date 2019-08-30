package com.buyou.order.feign;

import com.buyou.order.feign.dto.OrderCreateParam;
import com.buyou.order.feign.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author evan
 */
public interface OrderApi {

    @PostMapping("/order")
    OrderDto createOrder(OrderCreateParam createParam);

    @GetMapping("/order")
    OrderDto findOrder(Long orderId);
}
