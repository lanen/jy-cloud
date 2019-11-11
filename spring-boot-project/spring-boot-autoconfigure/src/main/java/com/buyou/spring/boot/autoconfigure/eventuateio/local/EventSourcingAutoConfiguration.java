package com.buyou.spring.boot.autoconfigure.eventuateio.local;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置 CQRS.
 * Create date 2019-11-11
 * @author evan
 */
@Configuration
@EnableConfigurationProperties(EventSourcingProperties.class)
@ConditionalOnClass(EventuateDriverConfiguration.class)
@Import(EventuateDriverConfiguration.class)
@PropertySource("classpath:eventuate-local.properties")
@ConditionalOnProperty(prefix = "cqrs", name = "enabled", havingValue = "true")
public class EventSourcingAutoConfiguration {

}
