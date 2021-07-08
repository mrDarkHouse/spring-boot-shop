package com.darkhouse.test_shop.model;

import com.darkhouse.test_shop.entity.GoodsEntity;

import java.math.BigDecimal;

public class GoodsModel {
    private Long id;
    private String name;
    private BigDecimal price;

    public static GoodsModel toModel(GoodsEntity entity){
        GoodsModel model = new GoodsModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPrice(entity.getPrice());
        return model;
    }

    public GoodsModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
