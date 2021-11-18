package com.sharingan.comp380ecommercewebsite.cart;

import com.sharingan.comp380ecommercewebsite.product.Product;
import com.sharingan.comp380ecommercewebsite.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartRepository cartRepository;

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
}
