package com.sharingan.comp380ecommercewebsite.cart;

import com.sharingan.comp380ecommercewebsite.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 *
 * @author Michael Sanati
 * @since 2021-15-11
 */
@RestController
@RequestMapping("/api/cart")


/**
*@actions Cart Requests
*@return Product
*@return Product ID
*@return Product Quantity
*@return Product Price
*@remove Cart Item
*@return Cart Price
*/

public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	public List<Product> getProducts() {
		return cartService.getProducts();
	}

	@GetMapping("/quantity/{id}")
	public int getQuantityOfProduct(@PathVariable int id) {
		return cartService.getProductQuantity(id);
	}

	@GetMapping("/checkout/{id}")
	public double getPriceOfProductInCart(@PathVariable int id) {
		return cartService.getProductTotalPrice(id);
	}

	@PostMapping
	public void removeFromCart(@RequestBody Cart cartItem) {
		cartService.removeFromCart(cartItem);
	}

	@GetMapping("/checkout/total")
	public double getPriceOfCart() {
		return cartService.getPriceOfCart();
	}


}
