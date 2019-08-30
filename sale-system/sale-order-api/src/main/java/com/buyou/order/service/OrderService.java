package com.buyou.order.service;

import com.buyou.order.dao.OrderRepository;
import com.buyou.order.entity.OrderEntity;
import com.buyou.order.feign.dto.OrderCreateParam;
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

    /**
     *
     */
    private final OrderRepository orderRepository;


    /**
     *
     */
    private final OrderServiceSaga orderServiceSaga;

    /**
     *
     * @param orderRepository
     */
    public OrderService(OrderRepository orderRepository,
                        OrderServiceSaga orderServiceSaga) {
        this.orderRepository = orderRepository;
        this.orderServiceSaga = orderServiceSaga;
    }


    /**
     * 创建订单
     *
     * @param createParam
     * @return
     */
    public OrderEntity createOrder(OrderCreateParam createParam){

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(System.currentTimeMillis());


        logger.debug("save order {}", orderEntity);
        OrderEntity entity = orderRepository.save(orderEntity);

        logger.debug("fire order created event ");
        orderServiceSaga.applyOrderCreated();
        return entity;
    }

}
