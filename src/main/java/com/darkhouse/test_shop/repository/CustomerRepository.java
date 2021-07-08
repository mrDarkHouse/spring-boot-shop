package com.darkhouse.test_shop.repository;

import com.darkhouse.test_shop.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByUsername(String username);
}
