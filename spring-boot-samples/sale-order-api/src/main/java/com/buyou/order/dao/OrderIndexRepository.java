package com.buyou.order.dao;

import com.buyou.order.entity.OrderIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author evan
 * create date 2019/8/30
 */
@Repository
public interface OrderIndexRepository extends ElasticsearchRepository<OrderIndex, String> {
}
