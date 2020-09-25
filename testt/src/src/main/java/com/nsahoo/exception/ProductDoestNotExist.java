package com.nsahoo.exception;

public class ProductDoestNotExist extends Exception {
    String message;



    public ProductDoestNotExist(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }
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
}
