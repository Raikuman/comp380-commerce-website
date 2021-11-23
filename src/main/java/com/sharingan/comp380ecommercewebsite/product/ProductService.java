package com.sharingan.comp380ecommercewebsite.product;

import com.sharingan.comp380ecommercewebsite.cart.Cart;
import com.sharingan.comp380ecommercewebsite.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class provides the business logic for the product objects and provides these methods mainly to the
 * endpoint class, ProductController.java
 *
 * @author Jim Inong
 * @since 2021-22-11
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	/**
	 * This method returns a list of products from the product repository
	 * @return Returns a list of products
	 */
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	/**
	 * This method gets the product from the database using the id given
	 * @param id Provides the id to find a product
	 * @return Returns the product found in the database
	 */
	public Product findById(int id) {
		return productRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	/**
	 * This method saves a given cart object to the database. Before saving, it checks if there is already
	 * an existing cart object with the same productId. If there is an existing cart object, it updates it
	 * so that the quantity of the existing cart and the current cart is added, then saved to the database
	 * @param cartItem Provides the cart object to save to the database
	 * @return Returns the saved cart item
	 */
	public Cart saveToCart(Cart cartItem) {

		// Update quantity of currently existing product if applicable
		for (Cart cart : cartRepository.findAll()) {
			if (cart.getProductId() == cartItem.getProductId()) {
				Cart temp = new Cart(cart.getProductId(), (cart.getQuantity()) + cartItem.getQuantity());

				cartRepository.delete(cart);
				cartRepository.save(temp);
				return temp;
			}
		}

		cartRepository.save(cartItem);
		return cartItem;
	}
}
