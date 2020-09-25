package com.nsahoo.controller;

import com.nsahoo.dto.OrderDto;
import com.nsahoo.entity.OrderEntity;
import com.nsahoo.exception.OrderNotFoundException;
import com.nsahoo.exception.ProductDoestNotExist;
import com.nsahoo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/createOrder")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto) {
        OrderEntity order=null;
        try {
            order = service.createOrder(orderDto);
        }
        catch (ProductDoestNotExist e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(order);
    }

    @GetMapping("/showOrderById/{orderId}")
    public ResponseEntity getById(@PathVariable String orderId) {
        OrderEntity orderEntity = null;
        try {
            orderEntity = service.getOrderById(orderId);
        } catch (OrderNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(orderEntity);
    }

    @GetMapping("/showAllOrders")
    public ResponseEntity<List<OrderEntity>> getOrders() {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        orderEntityList = service.getOrders();
        return ResponseEntity.ok(orderEntityList);
    }

}
