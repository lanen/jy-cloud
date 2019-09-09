package com.buyou.zuul.hystrix;


import com.netflix.hystrix.HystrixCommand;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class OrderHystrixCommandTest {

    @Test
    public void run() {
        HystrixCommand.Setter setter = OrderHystrixCommand.setter();
        Order order = new Order();

        int t = 0;

        for (int i = 0; i < 110; i++) {
            OrderHystrixCommand command = new OrderHystrixCommand(order,setter);
            t = command.execute();
            System.out.println(t);

        }

//        Assert.assertEquals(-1, t);
    }
}
