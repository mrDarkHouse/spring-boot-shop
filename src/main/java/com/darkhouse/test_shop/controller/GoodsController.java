package com.darkhouse.test_shop.controller;

import com.darkhouse.test_shop.entity.GoodsEntity;
import com.darkhouse.test_shop.exception.CustomerAlreadyExistsException;
import com.darkhouse.test_shop.exception.CustomerNotFoundException;
import com.darkhouse.test_shop.exception.GoodsNotFoundException;
import com.darkhouse.test_shop.model.GoodsModel;
import com.darkhouse.test_shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    public GoodsController(@Autowired GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addGoods(@RequestBody GoodsEntity entity){
        try {
            goodsService.addGoods(entity);
            return ResponseEntity.ok("Goods added");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping()
    public ResponseEntity<List<GoodsModel>> getAllGoods(){
        return ResponseEntity.ok(goodsService.getAllGoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGoods(@PathVariable Long id){
        try {
            return ResponseEntity.ok(goodsService.getOneGoods(id));
        } catch (GoodsNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoods(@PathVariable Long id){
        try {
            return ResponseEntity.ok(goodsService.deleteOne(id));
        } catch (GoodsNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
