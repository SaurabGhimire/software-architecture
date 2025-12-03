package com.example.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ShoppingCartServic")
public interface ShoppingCartClient {
    @PostMapping("/carts/{cartId}/{quantity}")
    void addItem(@PathVariable("cartId") String cartId,
                 @PathVariable("quantity") int quantity,
                 @RequestBody ProductDTO product);

    @GetMapping("/carts/{cartId}")
    ShoppingCartDTO getCart(@PathVariable("cartId") String cartId);
}
