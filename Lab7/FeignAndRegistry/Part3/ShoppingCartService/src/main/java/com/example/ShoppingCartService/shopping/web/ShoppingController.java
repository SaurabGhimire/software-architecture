package com.example.ShoppingCartService.shopping.web;

import com.example.ShoppingCartService.shopping.service.ProductDTO;
import com.example.ShoppingCartService.shopping.service.ShoppingCartDTO;
import com.example.ShoppingCartService.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;
	
	@PostMapping(value = "/cart/{cartId}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId,  @PathVariable int quantity, @RequestBody ProductDTO productDto) {
		shoppingService.addToCart(cartId, productDto, quantity);
		return new ResponseEntity<ShoppingCartDTO>(HttpStatus.OK);
	}
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		ShoppingCartDTO cart = shoppingService.getCart(cartId);
		return new ResponseEntity<ShoppingCartDTO>(cart, HttpStatus.OK);
	}

	
}
