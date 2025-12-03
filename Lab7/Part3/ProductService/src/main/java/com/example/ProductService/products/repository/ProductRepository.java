package com.example.ProductService.products.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ProductService.products.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
