package com.darkhouse.test_shop.repository;

import com.darkhouse.test_shop.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
