package com.sharingan.comp380ecommercewebsite.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
   
   @Autowired 
   private ProductService productService;
   
   @Autowired 
   private CartService cartService;

	public Product findById(int id) {
		return product.findById(id);
	}

public List<Product> getProducts() {
  
   List<Cart> cartList = cartRepository.findAll();
   List<Product> productList = new ArrayList<>();

   for (Cart cartItem : cartList) {
      
      productList.add(findbyid);
}

   return productList;    
}

}
