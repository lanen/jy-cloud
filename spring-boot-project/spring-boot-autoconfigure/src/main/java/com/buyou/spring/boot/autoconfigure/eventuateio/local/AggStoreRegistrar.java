package com.buyou.spring.boot.autoconfigure.eventuateio.local;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import java.beans.Introspector;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * Create date 2019-11-18.
 *
 * @author evan
 */
public class AggStoreRegistrar implements ImportBeanDefinitionRegistrar,
    ResourceLoaderAware, EnvironmentAware {

  /**
   * 配置信息.
   */
  private Environment environment;

  /**
   * 资源加载器.
   */
  private ResourceLoader resourceLoader;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @Override
  public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
      BeanDefinitionRegistry beanDefinitionRegistry) {
    annotationMetadata.getAnnotatedMethods(EnableAggStore.class.getName());
    AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(AggStore.class);
    ClassPathScanningCandidateComponentProvider scanner = getScanner();
    Set<String> basePackages = getBasePackages(annotationMetadata);
    scanner.addIncludeFilter(annotationTypeFilter);
    for (String basePackage : basePackages) {
      Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
      for (BeanDefinition candidateComponent : candidateComponents) {
        if (candidateComponent instanceof AnnotatedBeanDefinition) {
          AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition)candidateComponent;
          AnnotationMetadata metadata = beanDefinition.getMetadata();
          Map<String, Object> annotationAttributes = metadata
              .getAnnotationAttributes(AggStore.class.getCanonicalName());
          Object agg = annotationAttributes.get("agg");
          Object cmd = annotationAttributes.get("cmd");
          String beanName = (String)annotationAttributes.get("name");

          BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AggStoreFactoryBean.class);
          beanDefinitionBuilder.addPropertyValue("aggregateType",agg);
          beanDefinitionBuilder.addPropertyValue("commandType",cmd);
          beanDefinitionBuilder.setLazyInit(true);

          String st = Introspector.decapitalize(ClassUtils.getShortName(EventuateAggregateStore.class));

          beanDefinitionBuilder.addDependsOn(st);
          beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

          beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());

        }
      }
    }

  }

  protected Set<String> getBasePackages(AnnotationMetadata meda) {
    Map<String, Object> attributes = meda
        .getAnnotationAttributes(EnableAggStore.class.getCanonicalName());
    Set<String> pkgs = new HashSet<>();

    for (String pkg : (String[]) attributes.get("value")) {
      if (StringUtils.hasText(pkg)) {
        pkgs.add(pkg);
      }
    }
    for (String pkg : (String[]) attributes.get("basePackages")) {
      if (StringUtils.hasText(pkg)) {
        pkgs.add(pkg);
      }
    }

    for (Class<?> clazz : (Class[]) attributes.get("basePackageClasses")) {
      pkgs.add(ClassUtils.getPackageName(clazz));
    }

    if (pkgs.isEmpty()) {
      pkgs.add(ClassUtils.getPackageName(meda.getClassName()));
    }
    return pkgs;
  }

  protected ClassPathScanningCandidateComponentProvider getScanner() {
    return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
      @Override
      protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        boolean isCandidate = false;
        if (beanDefinition.getMetadata().isIndependent()) {
          if (!beanDefinition.getMetadata().isAnnotation()) {
            isCandidate = true;
          }
        }
        return isCandidate;
      }
    };
  }
}
