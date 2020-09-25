package com.nsahoo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto implements Serializable {
    String orderId;
    String customerName;
    LocalDateTime orderDate;
    Address address;
    List<OrderItemDto> orderItems;
    Double orderTotal;

    public String getOrderId() {
        return orderId;
    }

    public OrderDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderDto setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderDto setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public OrderDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public OrderDto setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public OrderDto setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }
}
