package com.buyou.order.config;

import com.buyou.order.service.OrderIndexService;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author evan
 * create date 2019/9/3
 */
@Configuration
@Import({TramJdbcKafkaConfiguration.class})
public class OrderQueryConfiguration {


    @Bean
    public  OrderEventConsumer orderEventConsumer(OrderIndexService orderIndexService){
        return new OrderEventConsumer(orderIndexService);
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(OrderEventConsumer orderEventConsumer, MessageConsumer messageConsumer){

        DomainEventDispatcher dispatcher = new DomainEventDispatcher("saleOrder",
                orderEventConsumer.domainEventHandlers(),
                messageConsumer);

        return dispatcher;
    }
}
