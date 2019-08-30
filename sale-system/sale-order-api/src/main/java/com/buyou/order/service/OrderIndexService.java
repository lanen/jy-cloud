package com.buyou.order.service;

import com.buyou.order.dao.OrderIndexRepository;
import com.buyou.order.entity.OrderEntity;
import com.buyou.order.entity.OrderIndex;

import org.springframework.stereotype.Service;

/**
 * @author evan
 * create date 2019/8/30
 */
@Service
public class OrderIndexService {

    private final OrderIndexRepository orderIndexRepository;

    public OrderIndexService(OrderIndexRepository orderIndexRepository) {
        this.orderIndexRepository = orderIndexRepository;
    }

    /**
     *
     * @param entity
     */
    public void save(OrderEntity entity){

        OrderIndex orderIndex = new OrderIndex();
        orderIndex.setCustomer("1");
        orderIndex.setId(String.valueOf(System.currentTimeMillis()));

        orderIndexRepository.save(orderIndex);
    }


}
