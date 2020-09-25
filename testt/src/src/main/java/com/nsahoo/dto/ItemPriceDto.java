package com.nsahoo.dto;

import java.io.Serializable;

public class ItemPriceDto implements Serializable {
    String itemId;
    Double unitprice;

    public String getItemId() {
        return itemId;
    }

    public ItemPriceDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public ItemPriceDto setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
        return this;
    }

    @Override
    public String toString() {
        return "ItemPriceDto{" +
                "itemId='" + itemId + '\'' +
                ", unitprice=" + unitprice +
                '}';
    }
}
