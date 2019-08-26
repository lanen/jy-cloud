package com.buyou.order.service;

import com.buyou.order.dao.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author evan
 */
@Service
@Transactional
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;


    /**
     *
     * @param orderRepository
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


}
