package com.buyou.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author evan
 * create date 2019/8/30
 */
@Document(indexName = "orders", type = "_doc")
public class OrderIndex {


    @Id
    private String id;

    private String customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
