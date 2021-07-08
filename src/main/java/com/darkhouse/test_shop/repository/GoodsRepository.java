package com.darkhouse.test_shop.repository;

import com.darkhouse.test_shop.entity.GoodsEntity;
import org.springframework.data.repository.CrudRepository;

public interface GoodsRepository extends CrudRepository<GoodsEntity, Long> {
}
