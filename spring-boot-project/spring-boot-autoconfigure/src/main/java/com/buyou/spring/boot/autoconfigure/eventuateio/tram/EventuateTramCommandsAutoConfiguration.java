package com.buyou.spring.boot.autoconfigure.eventuateio.tram;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * 生产消息的配置
 *
 * @author evan
 * @date 2019-09-09
 */
@Configuration
@Import({TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class})
public class EventuateTramCommandsAutoConfiguration {
}
