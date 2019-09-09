package com.buyou.order.service;

import com.buyou.order.dao.OrderIndexRepository;
import com.buyou.order.entity.OrderIndex;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author evan
 * create date 2019/8/30
 */
@Service
public class OrderIndexService {

    private final OrderIndexRepository orderIndexRepository;

    public OrderIndexService(OrderIndexRepository orderIndexRepository) {
        this.orderIndexRepository = orderIndexRepository;
    }

    /**
     *
     * @param orderIndex
     */
    public void save(OrderIndex orderIndex){

        orderIndexRepository.save(orderIndex);

    }


    public List<OrderIndex> search(){
        Iterable<OrderIndex> all = orderIndexRepository.findAll();

        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }
}
