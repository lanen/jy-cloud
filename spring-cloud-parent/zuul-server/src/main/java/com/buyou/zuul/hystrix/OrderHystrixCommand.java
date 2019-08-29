package com.buyou.zuul.hystrix;

import com.netflix.hystrix.*;

/**
 * hystrix command for order
 *
 * @author evan
 */
public class OrderHystrixCommand extends HystrixCommand<Integer> {


    private final Order order;

    public static Setter setter(){

        return Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("order"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("count"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10));
    }

    public OrderHystrixCommand(Order order, Setter setter) {
        super(setter);
        this.order = order;
    }

    @Override
    protected Integer run() throws Exception {
        return order.count();
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }
}
