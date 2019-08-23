package com.buyou.order.entity;


import javax.persistence.*;

@Entity
@Table(name="sale_order")
public class OrderEntity {

    @Id
    @GeneratedValue(generator = "order_sed_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="order_sed_id")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name="order_id")
    private long orderId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
