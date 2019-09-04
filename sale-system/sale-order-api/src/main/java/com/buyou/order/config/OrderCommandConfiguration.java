package com.buyou.order.config;


import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author evan
 * create date 2019/9/2
 */
@Configuration
@Import({TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class})
public class OrderCommandConfiguration {

}
