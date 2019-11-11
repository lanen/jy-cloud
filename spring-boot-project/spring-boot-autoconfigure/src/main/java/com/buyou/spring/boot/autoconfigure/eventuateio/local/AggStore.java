package com.buyou.spring.boot.autoconfigure.eventuateio.local;

/**
 * Create date 2019-11-18.
 *
 * @author evan
 */
public @interface AggStore {

  Class<?> agg() default void.class;

  String name() default "";

  Class<?> cmd() default void.class;

}
