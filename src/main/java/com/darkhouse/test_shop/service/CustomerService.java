package com.darkhouse.test_shop.service;

import com.darkhouse.test_shop.entity.CustomerEntity;
import com.darkhouse.test_shop.exception.CustomerAlreadyExistsException;
import com.darkhouse.test_shop.exception.CustomerNotFoundException;
import com.darkhouse.test_shop.model.CustomerModel;
import com.darkhouse.test_shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity registerCustomer(CustomerEntity customer) throws CustomerAlreadyExistsException {
        if(customerRepository.findByUsername(customer.getUsername()) != null){
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }

    public CustomerModel getOne(Long id) throws CustomerNotFoundException {
        CustomerEntity e = customerRepository.findById(id)
                .orElseThrow(CustomerNotFoundException::new);
        System.out.println(e.getOrders());
        return CustomerModel.toModel(e);
    }

    public CustomerModel deleteOne(Long id) throws CustomerNotFoundException {
        CustomerModel model = getOne(id);
        customerRepository.deleteById(id);
        return model;
    }
}
