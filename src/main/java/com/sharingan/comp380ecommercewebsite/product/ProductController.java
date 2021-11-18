package com.sharingan.comp380ecommercewebsite.product;

import com.sharingan.comp380ecommercewebsite.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// No specific map, show all products
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	// Id mapping, show product with id
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	@PostMapping
	public Cart addToCart(@RequestBody Cart cartItem) {
		return productService.saveToCart(cartItem);
	}
}
