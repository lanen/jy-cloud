package com.buyou.zuul.hystrix;

public class Order {

    public Integer count(){
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
