package com.darkhouse.test_shop.service;

import com.darkhouse.test_shop.entity.CustomerEntity;
import com.darkhouse.test_shop.entity.GoodsEntity;
import com.darkhouse.test_shop.entity.OrderEntity;
import com.darkhouse.test_shop.exception.CustomerNotFoundException;
import com.darkhouse.test_shop.exception.OrderNotFoundException;
import com.darkhouse.test_shop.model.OrderModel;
import com.darkhouse.test_shop.repository.CustomerRepository;
import com.darkhouse.test_shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(@Autowired OrderRepository orderRepository,
                        @Autowired CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public void addOrder(OrderEntity entity, Long customerId) throws CustomerNotFoundException {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
        entity.setCustomer(customer);


//        OrderEntity entity = new OrderEntity();
//        entity.setOrderDate(form.getOrderDate());
        orderRepository.save(entity);
    }

    public OrderModel getOrder(Long id) throws OrderNotFoundException {
        return OrderModel.toModel(orderRepository
                .findById(id)
                .orElseThrow(OrderNotFoundException::new)
        );
    }
}
