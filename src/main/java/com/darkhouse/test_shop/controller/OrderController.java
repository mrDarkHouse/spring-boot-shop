package com.darkhouse.test_shop.controller;

import com.darkhouse.test_shop.entity.OrderEntity;
import com.darkhouse.test_shop.exception.OrderNotFoundException;
import com.darkhouse.test_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody OrderEntity orderEntity,
                                      @RequestParam Long customerId){
        try {
            orderService.addOrder(orderEntity, customerId);
            return ResponseEntity.ok("Order added");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){
        try {
            return ResponseEntity.ok(orderService.getOrder(id));
        } catch (OrderNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
