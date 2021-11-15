package com.sharingan.comp380ecommercewebsite.cart;

import com.sharingan.comp380ecommercewebsite.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class CartController {

	@Autowired
	private CartService cartService;

	
	@GetMapping("/{id}")
	public Cart findById(@PathVariable int id) {
		return cartService.findById(id);
	}
   
public List<Product> getProducts() {
  
   List<Cart> cartList = cartRepository.findAll();
   List<Product> productList = new ArrayList<>();

   for (Cart cartItem : cartList) {
      
      productList.add(findbyid);
}

   return productList;   
}  

   List<Object> myList;
   for (Object tempName : myList) {
      
      tempName.getShit();
} 
}
