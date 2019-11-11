package com.buyou.order.service;

import com.buyou.order.domain.SaleOrder;
import com.buyou.order.domain.SaleOrderCreated;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author evan
 * create date 2019/8/30
 */
@Service
public class OrderServiceSaga {


    /**
     *
     */
    private final DomainEventPublisher domainEventPublisher;


    /**
     *
     * @param domainEventPublisher
     */
    public OrderServiceSaga(DomainEventPublisher domainEventPublisher) {
        this.domainEventPublisher = domainEventPublisher;
    }

    /**
     *
     */
    public void applyOrderCreated(Long orderId){
        SaleOrderCreated created = new SaleOrderCreated();
        created.setOrderId(orderId);
        domainEventPublisher.publish(SaleOrder.class, orderId, Arrays.asList(created));
    }
}
