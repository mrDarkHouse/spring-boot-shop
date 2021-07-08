package com.darkhouse.test_shop.service;

import com.darkhouse.test_shop.entity.GoodsEntity;
import com.darkhouse.test_shop.exception.CustomerNotFoundException;
import com.darkhouse.test_shop.exception.GoodsNotFoundException;
import com.darkhouse.test_shop.model.CustomerModel;
import com.darkhouse.test_shop.model.GoodsModel;
import com.darkhouse.test_shop.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService(@Autowired GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void addGoods(GoodsEntity entity){
        goodsRepository.save(entity);
    }

    public GoodsModel getOneGoods(Long id) throws GoodsNotFoundException {
        return GoodsModel.toModel(goodsRepository
                .findById(id)
                .orElseThrow(GoodsNotFoundException::new)
        );
    }

    public List<GoodsModel> getAllGoods(){
        List<GoodsEntity> list = new ArrayList<>();
        goodsRepository.findAll().forEach(list::add);
        return list.stream()
                .map(GoodsModel::toModel)
                .collect(Collectors.toList());
    }

    public GoodsModel deleteOne(Long id) throws GoodsNotFoundException {
        GoodsModel model = getOneGoods(id);
        goodsRepository.deleteById(id);
        return model;
    }

}
