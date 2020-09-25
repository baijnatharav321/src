package com.nsahoo.client;

import com.nsahoo.dto.OrderItemDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="ORDER-ITEM-SERVICE" , url = "http://localhost:8085")
public interface OrderItemClientService {


    @RequestMapping(value = "/OrderItem/showItems/{productCode}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<OrderItemDto> showItemByCode(@PathVariable String productCode);

}
