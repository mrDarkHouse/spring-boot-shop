package com.darkhouse.test_shop.model;

import com.darkhouse.test_shop.entity.CustomerEntity;
import com.darkhouse.test_shop.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerModel {
    private Long id;
    private String username;
    private String address;
    private List<OrderModel> orderEntities;

    public static CustomerModel toModel(CustomerEntity entity){
        CustomerModel model = new CustomerModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setAddress(entity.getAddress());
        model.setOrderEntities(entity.getOrders()
                .stream()
                .map(OrderModel::toModel)
                .collect(Collectors.toList())
        );
        return model;
    }

    public CustomerModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderModel> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderModel> orderEntities) {
        this.orderEntities = orderEntities;
    }
}
