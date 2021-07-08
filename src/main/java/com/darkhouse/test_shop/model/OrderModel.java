package com.darkhouse.test_shop.model;

import com.darkhouse.test_shop.entity.OrderEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderModel {
    private Long id;
    private LocalDateTime orderDate;
    private List<GoodsModel> goods;

    public static OrderModel toModel(OrderEntity entity){
        OrderModel model = new OrderModel();
        model.setId(entity.getId());
        model.setOrderDate(entity.getOrderDate());
        model.setGoods(entity.getGoods()
                .stream()
                .map(GoodsModel::toModel)
                .collect(Collectors.toList())
        );
        return model;
    }

    public OrderModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<GoodsModel> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsModel> goods) {
        this.goods = goods;
    }
}
