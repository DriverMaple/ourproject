package com.mooc.entity;

public class Order {
    private Long orderId;

    public Order(Long orderId) {
        this.orderId = orderId;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}