package com.example.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductServiceApplication implements CommandLineRunner {
	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Product product = new Product(
				10,
				"iphone");
		int stock = productService.getStockCount(product.getProductNumber());
		product.setStockNumber(stock);
		System.out.println(product);

	}
}
