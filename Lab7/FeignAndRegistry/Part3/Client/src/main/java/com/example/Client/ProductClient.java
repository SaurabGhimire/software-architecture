package com.example.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="ProductService")
public interface ProductClient {
    @PostMapping("/products")
    void createProduct(@RequestBody ProductDTO dto);

    @GetMapping("/products/{number}")
    ProductDTO getProduct(@PathVariable("number") String number);
}
