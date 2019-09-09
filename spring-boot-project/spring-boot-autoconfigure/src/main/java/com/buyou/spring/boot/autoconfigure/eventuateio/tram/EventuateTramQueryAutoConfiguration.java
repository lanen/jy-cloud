package com.buyou.spring.boot.autoconfigure.eventuateio.tram;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
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
@Import({TramJdbcKafkaConfiguration.class})
public class EventuateTramQueryAutoConfiguration {
}
