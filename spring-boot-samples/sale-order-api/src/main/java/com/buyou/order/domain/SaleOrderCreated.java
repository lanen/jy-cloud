package com.buyou.order.domain;

import io.eventuate.tram.events.common.DomainEvent;

/**
 * @author evan
 * create date 2019/9/2
 */
public class SaleOrderCreated implements DomainEvent {

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
