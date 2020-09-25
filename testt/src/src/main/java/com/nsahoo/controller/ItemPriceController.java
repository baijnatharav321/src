package com.nsahoo.controller;

import com.nsahoo.dto.ItemPriceDto;
import com.nsahoo.service.ItemPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemPrice")
public class ItemPriceController {

    @Autowired
    private ItemPriceService service;
    @PostMapping("/SaveItemPrice")
    public ResponseEntity saveOrder(@RequestBody ItemPriceDto itemPriceDto) {
        itemPriceDto = service.saveItemPrice(itemPriceDto);
        return ResponseEntity.ok(itemPriceDto);
    }

}
