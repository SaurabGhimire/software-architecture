package com.example.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class ProductService {
    @Autowired
    StockFeignClient stockFeignClient;

    public int getStockCount(int productId){
        return stockFeignClient.getStockCount(productId);
    }

    @FeignClient("StockService")
    interface  StockFeignClient {
        @RequestMapping("/stock/{productId}")
        public int getStockCount(@PathVariable("productId") int productId);
    }

}
