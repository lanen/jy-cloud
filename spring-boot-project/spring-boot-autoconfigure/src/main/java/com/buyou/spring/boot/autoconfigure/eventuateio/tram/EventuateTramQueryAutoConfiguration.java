package com.buyou.spring.boot.autoconfigure.eventuateio.tram;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * 消费消息的配置
 *
 * @author evan
 * @date 2019-09-09
 */
@Configuration
@ConditionalOnProperty(value = "crqs.enabled", havingValue = "true")
@ConditionalOnClass(name="io.eventuate.jdbckafka.TramJdbcKafkaConfiguration")
@Import({TramJdbcKafkaConfiguration.class})
public class EventuateTramQueryAutoConfiguration {
}
