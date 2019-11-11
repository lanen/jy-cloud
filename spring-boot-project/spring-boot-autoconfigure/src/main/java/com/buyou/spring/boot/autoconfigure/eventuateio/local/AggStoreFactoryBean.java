package com.buyou.spring.boot.autoconfigure.eventuateio.local;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import java.lang.reflect.Constructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ClassUtils;

/**
 * Create date 2019-11-19.
 *
 * @author evan
 */
public class AggStoreFactoryBean implements FactoryBean<Object>,
    InitializingBean, ApplicationContextAware {

  private ApplicationContext applicationContext;

  private Class<?> aggregateType;

  private Class<?> commandType;


  @Override
  public Object getObject() throws Exception {
    EventuateAggregateStore bean = applicationContext.getBean(EventuateAggregateStore.class);
    Constructor<AggregateRepository> constructorIfAvailable = ClassUtils
        .getConstructorIfAvailable(AggregateRepository.class, Class.class,
            EventuateAggregateStore.class);
    return BeanUtils.instantiateClass(constructorIfAvailable, aggregateType, bean);
  }

  @Override
  public Class<?> getObjectType() {
    return AggregateRepository.class;
  }

  @Override
  public void afterPropertiesSet() throws Exception {

  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  public Class<?> getAggregateType() {
    return aggregateType;
  }

  public void setAggregateType(Class<?> aggregateType) {
    this.aggregateType = aggregateType;
  }

  public Class<?> getCommandType() {
    return commandType;
  }

  public void setCommandType(Class<?> commandType) {
    this.commandType = commandType;
  }
}
