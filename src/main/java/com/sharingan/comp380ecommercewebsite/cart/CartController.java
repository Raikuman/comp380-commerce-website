package com.sharingan.comp380ecommercewebsite.cart;

import com.sharingan.comp380ecommercewebsite.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	public List<Product> getProducts() {
		return cartService.getProducts();
	}

}
