package com.nsahoo.service;

import com.nsahoo.dto.ItemPriceDto;
import com.nsahoo.entity.ItemPriceEntity;
import com.nsahoo.repository.ItemPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPriceService {
    @Autowired
    private ItemPriceRepository itemPriceRepository;

    public ItemPriceDto saveItemPrice(ItemPriceDto itemPriceDto) {

        ItemPriceEntity itemPriceEntity = new ItemPriceEntity();
        itemPriceEntity.setItemId(itemPriceDto.getItemId());
        itemPriceEntity.setUnitprice(itemPriceDto.getUnitprice());
        itemPriceRepository.save(itemPriceEntity);
        return itemPriceDto;
    }

}
