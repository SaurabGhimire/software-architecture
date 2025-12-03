package com.example.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	ProductClient productClient;

	@Autowired
	ShoppingCartClient shoppingCartClient;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		//create products

//		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("A33","TV",450.0));
//		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("A34","MP3 Player",75.0));
		productClient.createProduct(new ProductDTO("A33","TV",450.0));
		productClient.createProduct(new ProductDTO("A34","MP3 Player",75.0));

		//get a product and add to the shoppingcart
		ProductDTO product = productClient.getProduct("A33");
		shoppingCartClient.addItem("1", 3, product);
		//get a product and add to the shoppingcart
		product = productClient.getProduct("A34");
		shoppingCartClient.addItem("1", 2, product);
		//get the shoppingcart
		ShoppingCartDTO cart = shoppingCartClient.getCart("1");
		System.out.println("\n-----Shoppingcart-------");
		if (cart != null) cart.print();

	}


}
