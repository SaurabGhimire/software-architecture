package com.example.ShoppingCartService.shopping.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.ShoppingCartService.shopping.domain.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
