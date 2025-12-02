package com.example.StockService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @GetMapping("/{productNumber}")
    public int getStock(@PathVariable int productNumber){
        if(productNumber==1){
            return 100;
        } else if(productNumber==2){
            return 200;
        }
        return 500;
    }
}
