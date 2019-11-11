package com.buyou.order.controller;

import com.buyou.order.entity.OrderIndex;
import com.buyou.order.service.OrderIndexService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author evan create date 2019/8/30
 */
@RestController
public class OrderQueryController {

  private final OrderIndexService orderIndexService;

  /**
   * construct
   *
   * @param orderIndexService order index service
   */
  public OrderQueryController(OrderIndexService orderIndexService) {
    this.orderIndexService = orderIndexService;
  }


  /**
   *
   */
  @GetMapping("/q")
  public String ok() {
    orderIndexService.save(null);
    return "OK";
  }

  /**
   *
   */
  @GetMapping("/s")
  public List<OrderIndex> search() {
    return orderIndexService.search();
  }


}
