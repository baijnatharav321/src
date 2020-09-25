package com.nsahoo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemPriceEntity {

    @Id
    String itemId;
    Double unitprice;

    public String getItemId() {
        return itemId;
    }

    public ItemPriceEntity setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public ItemPriceEntity setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
        return this;
    }
}
