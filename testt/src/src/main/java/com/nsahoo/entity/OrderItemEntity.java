package com.nsahoo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItemEntity {


    @Id
    String productCode;
    String productName;
    Integer quantity;

    public String getProductCode() {
        return productCode;
    }

    public OrderItemEntity setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public OrderItemEntity setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
