package com.example.ShoppingCartService.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ShoppingCartService.shopping.domain.Product;
import com.example.ShoppingCartService.shopping.domain.ShoppingCart;
import com.example.ShoppingCartService.shopping.repository.ShoppingCartRepository;

import java.util.Optional;

@Service
public class ShoppingService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;


	public void addToCart(String cartId, ProductDTO productDto, int quantity) {
		//create a shopping product from a products product
		Product product = new Product(productDto.getProductnumber(),productDto.getDescription(),productDto.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartId);
		if (cartOptional.isPresent() && product != null) {
			ShoppingCart cart = cartOptional.get();
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}
		else if (product != null) {
			ShoppingCart cart = new ShoppingCart();
			cart.setCartid(cartId);
			cart.addToCart(product, quantity);
			shoppingCartRepository.save(cart);
		}		
	}
	
	public ShoppingCartDTO getCart(String cartId) {
		Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
		if (cart.isPresent())
		  return ShoppingCartAdapter.getShoppingCartDTO(cart.get());
		else
			return null;
	}


}
