package com.darkhouse.test_shop.exception;

public class GoodsNotFoundException extends Exception{
    public GoodsNotFoundException() {
        super("Goods not found");
    }
}
