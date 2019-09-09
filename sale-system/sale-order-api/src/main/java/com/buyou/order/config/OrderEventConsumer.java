package com.buyou.order.config;

import com.buyou.order.domain.SaleOrder;
import com.buyou.order.domain.SaleOrderCreated;
import com.buyou.order.entity.OrderIndex;
import com.buyou.order.service.OrderIndexService;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

/**
 * @author evan
 * create date 2019/9/4
 */
public class OrderEventConsumer {

    private final OrderIndexService orderIndexService;

    public OrderEventConsumer(OrderIndexService orderIndexService) {
        this.orderIndexService = orderIndexService;
    }

    public DomainEventHandlers domainEventHandlers(){
        return DomainEventHandlersBuilder
                .forAggregateType(SaleOrder.class.getName())
                .onEvent(SaleOrderCreated.class,this::applySaleOrderCreated)
                .build();
    }

    public void applySaleOrderCreated(DomainEventEnvelope<SaleOrderCreated> saleOrderCreated){
        SaleOrderCreated event = saleOrderCreated.getEvent();

        OrderIndex orderIndex = new OrderIndex();
        orderIndex.setCustomer("1");
        orderIndex.setId(String.valueOf(event.getOrderId()));

        System.out.println("DDD");
        orderIndexService.save(orderIndex);
    }

}
