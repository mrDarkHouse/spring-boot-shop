package com.darkhouse.test_shop.controller;

import com.darkhouse.test_shop.entity.CustomerEntity;
import com.darkhouse.test_shop.exception.CustomerAlreadyExistsException;
import com.darkhouse.test_shop.exception.CustomerNotFoundException;
import com.darkhouse.test_shop.model.CustomerModel;
import com.darkhouse.test_shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private final CustomerService customerService;

    public CustomersController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerEntity customerEntity){
        try {
            customerService.registerCustomer(customerEntity);
            return ResponseEntity.ok("Customer added");
        } catch (CustomerAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneCustomer(@PathVariable Long id){
        try {
            return ResponseEntity.ok(customerService.getOne(id));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try {
            return ResponseEntity.ok(customerService.deleteOne(id));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
