package com.buyou.spring.boot.autoconfigure.eventuateio.tram;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 *
 * 生产消息的配置.
 *
 * @author evan
 * data 2019-09-09
 */
@Configuration
@ConditionalOnProperty(value = "crqs.enabled", havingValue = "true")
@ConditionalOnClass(name = "io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration")
@Import(EventuateTramCommandsConfiguration.class)
public class EventuateTramCommandsAutoConfiguration {
}
