package com.buyou.spring.boot.autoconfigure.eventuateio.tram;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author evan
 * date 2019-09-09
 */
@PropertySource("classpath:eventuate-tram.properties")
@Import({TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class})
public class EventuateTramCommandsConfiguration {
}
