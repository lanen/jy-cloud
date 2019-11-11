package com.buyou.page;


import com.buyou.order.feign.OrderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("SALE-ORDER-API")
public interface OrderClient extends OrderApi {
}
