package com.sharingan.comp380ecommercewebsite.product;

import com.sharingan.comp380ecommercewebsite.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class exposes the endpoints for the product objects and uses methods from the productService class
 * for logic
 *
 * @author Jim Inong
 * @since 2021-22-11
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Base GetMapping for "/api/product" to get a list of products from the service
	 * @return Returns a list of product objects
	 */
	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	/**
	 * This method finds a product by its id and returns the product object
	 * @param id Provides the id from the mapping "/{id}"
	 * @return Returns a product object
	 */
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	/**
	 * This method gets a post request from the webpage and uses the RequestBody Cart object for the
	 * product service to add to the cart database
	 * @param cartItem Provides a cart item object
	 * @return Returns a cart item object
	 */
	@PostMapping
	public Cart addToCart(@RequestBody Cart cartItem) {
		return productService.saveToCart(cartItem);
	}
}
