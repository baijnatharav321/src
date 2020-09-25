package com.nsahoo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    String orderId;
    String customerName;
    LocalDateTime orderDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    AddressEntity address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ITEM")
    List<OrderItemEntity> orderItems;
    Double orderTotal;

    public String getOrderId() {
        return orderId;
    }

    public OrderEntity setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderEntity setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderEntity setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public OrderEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public List<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public OrderEntity setOrderItems(List<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public OrderEntity setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }
}
