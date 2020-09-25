package com.nsahoo.service;

import com.nsahoo.client.OrderItemClientService;
import com.nsahoo.dto.Address;
import com.nsahoo.dto.OrderDto;
import com.nsahoo.dto.OrderItemDto;
import com.nsahoo.entity.AddressEntity;
import com.nsahoo.entity.ItemPriceEntity;
import com.nsahoo.entity.OrderEntity;
import com.nsahoo.entity.OrderItemEntity;
import com.nsahoo.exception.OrderNotFoundException;
import com.nsahoo.exception.ProductDoestNotExist;
import com.nsahoo.repository.ItemPriceRepository;
import com.nsahoo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ItemPriceRepository itemPriceRepository;
    @Autowired
    private OrderItemClientService orderItemClientService;

    @Transactional
    public OrderEntity createOrder(OrderDto orderDto) throws ProductDoestNotExist {
        OrderEntity orderEntity = null;
        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderDto.getOrderItems()) {
            //call orderItem service to get the order item availability
            ResponseEntity<OrderItemDto> orderItem = null;
            try {
                orderItem = orderItemClientService.showItemByCode(orderItemDto.getProductCode());
            } catch (Exception e) {
                throw new ProductDoestNotExist("Couldn't find a Product with given ProductCode: " + orderItemDto.getProductCode());

            }
            OrderItemDto orderItemBody = orderItem.getBody();
            if (orderItemBody != null) {
                Integer quantity = orderItemBody.getQuantity();
                if (orderItemDto.getQuantity() < quantity) {
                    OrderItemEntity orderItemEntity = getorderItemEntity(orderItemDto);
                    orderItemEntityList.add(orderItemEntity);
                }
            }
        }

        if (!orderItemEntityList.isEmpty()) {
            orderEntity = toEntity(orderDto);
            orderEntity.setOrderItems(orderItemEntityList);
            populateOrderTotal(orderEntity);
            repository.save(orderEntity);
        }
        return orderEntity;
    }

    @Transactional
    public OrderEntity getOrderById(String orderId) throws OrderNotFoundException {
        Optional<OrderEntity> optionalOrder = repository.findById(orderId);
        return optionalOrder.orElseThrow(() -> new OrderNotFoundException("Couldn't find a order with id: " + orderId));
    }

    @Transactional
    public List<OrderEntity> getOrders() {
        return (List<OrderEntity>) repository.findAll();
    }


    private OrderItemEntity getorderItemEntity(OrderItemDto orderItemDto) {

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setProductCode(orderItemDto.getProductCode());
        orderItemEntity.setProductName(orderItemDto.getProductName());
        orderItemEntity.setQuantity(orderItemDto.getQuantity());
        return orderItemEntity;
    }


    private void populateOrderTotal(OrderEntity orderEntity) {
        Double orderTotal = 0d;
        for (OrderItemEntity orderItemEntity : orderEntity.getOrderItems()) {
            Optional<ItemPriceEntity> byId = itemPriceRepository.findById(orderItemEntity.getProductCode());
            if (byId.isPresent()) {
                ItemPriceEntity itemPriceEntity = byId.get();
                Double unitprice = itemPriceEntity.getUnitprice();
                orderTotal += unitprice * orderItemEntity.getQuantity();
            }
        }
        orderEntity.setOrderTotal(orderTotal);
    }


    private OrderEntity toEntity(OrderDto dto) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(dto.getOrderId());
        entity.setCustomerName(dto.getCustomerName());
        entity.setOrderDate(LocalDateTime.now());
        Address address = dto.getAddress();
        if (address != null) {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddressLine1(address.getAddressLine1());
            addressEntity.setCity(address.getCity());
            addressEntity.setZipcode(address.getZipcode());
            addressEntity.setCountry(address.getCountry());
            addressEntity.setState(address.getState());
            entity.setAddress(addressEntity);

        }
        return entity;
    }


}




