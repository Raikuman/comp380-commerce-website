package com.sharingan.comp380ecommercewebsite.cart;

import javax.persistence.*;

/**
 *
 *
 * @author Michael Sanati
 * @since 2021-15-11
 */
@Entity
public class Cart {

	@Id
	@Column(
		name = "cartid"
	)
	private int cartID;

	@Column(
		name = "productid"
	)
	private int productId;

	@Column(
		name = "quantity"
	)
	private int quantity;

	public Cart(){}

	public Cart(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getCartID() {
		return cartID;
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
}
