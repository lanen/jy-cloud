package com.buyou.spring.boot.autoconfigure.eventuateio.local;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * Create date 2019-11-18.
 *
 * @author evan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AggStoreRegistrar.class)
public @interface EnableAggStore {

  String[] value() default {};

  String[] basePackages() default {};

  Class[] basePackageClasses() default {};
}
