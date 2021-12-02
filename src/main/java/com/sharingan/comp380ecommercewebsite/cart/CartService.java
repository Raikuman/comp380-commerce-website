package com.sharingan.comp380ecommercewebsite.cart;

import com.sharingan.comp380ecommercewebsite.confirmation.Mail;
import com.sharingan.comp380ecommercewebsite.product.Product;
import com.sharingan.comp380ecommercewebsite.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @autowire ProductService
 * @autowire Cart Repository
 * @return Cart List
 * @list Cart Products
 * @return Cart Total
 * @return Product Quantity
 * @return Product Cost
 * @increment Cart Total
 * @return incremented Cart Total
 * @author Michael Sanati
 * @since 2021-15-11
 */

@Service
public class CartService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartRepository cartRepository;

	public List<Cart> getCart() {
		return (List<Cart>) cartRepository.findAll();
	}

	public List<Product> getProducts() {

		List<Cart> cartList = (List<Cart>) cartRepository.findAll();
		List<Product> productList = new ArrayList<>();

		for (Cart cartItem : cartList) {
			productList.add(
				productService.findById(cartItem.getProductId())
			);
		}

		return productList;
	}

	public double getCartTotal() {

		double total = 0;
		for (Product product : getProducts()) {
			total += product.getPrice();
		}

		return total;
	}

	public int getProductQuantity(int productId) {

		for (Cart cart : cartRepository.findAll()) {
			if (cart.getProductId() == productId) {
				return cart.getQuantity();
			}
		}

		return 0;
	}

	public double getProductTotalPrice(int productId) {

		for (Cart cart : cartRepository.findAll()) {
			if (cart.getProductId() == productId) {
				return cart.getQuantity() * productService.findById(productId).getPrice();
			}
		}

		return 0;
	}

	public void removeFromCart(Cart cartItem) {

		for (Cart cart : cartRepository.findAll()) {
			if (cart.getProductId() == cartItem.getProductId()) {
				cartRepository.deleteById(cart.getCartID());
			}
		}
	}

	public static void sendEmail() {
		Mail.sendEmail();
	}

	public double getPriceOfCart() {

		double total = 0.0;

		for (Cart cart : cartRepository.findAll()) {
			for (int i = 0; i < cart.getQuantity(); i++) {
				total += productService.findById(cart.getProductId()).getPrice();
			}
		}

		return total;
	}

	public void check_cart_num_product(int num) {

		int count = 0;
		for (int i = 0; i < getProducts().size(); i++)
			count++;

		if (count == num)
			System.out.println("Check " + num + " products: Test pass");
		else
			System.out.println("Check " + num + " products: Test failed");
	}
}
