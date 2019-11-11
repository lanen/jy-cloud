package com.buyou.eventuateio.local.sample;

import com.buyou.spring.boot.autoconfigure.eventuateio.local.AggStore;
import com.buyou.spring.boot.autoconfigure.eventuateio.local.EnableAggStore;
import com.buyou.spring.boot.autoconfigure.eventuateio.local.EventSourcingAutoConfiguration;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Create date 2019-11-12
 *
 * @author evan
 */
@Configuration
@AutoConfigureAfter(EventSourcingAutoConfiguration.class)
public class AccountConfiguration {


//  @Bean
//  @ConditionalOnBean(EventuateAggregateStore.class)
//  @ConditionalOnMissingBean
//  public AggregateRepository<Account, AccountCommand> aggregateRepository(
//      EventuateAggregateStore eventuateAggregateStore) {
//    return new AggregateRepository<>(Account.class, eventuateAggregateStore);
//  }
  @Configuration
  @EnableAggStore
  public static class B{

  }

  @AggStore(agg=Account.class, name="aggregateRepository", cmd=AccountCommand.class)
  public static class N {

  }
}
