package com.sharingan.comp380ecommercewebsite.cart;

import javax.persistence.*;

@Entity
public class Cart {

   @Id
	@GeneratedValue(strategy = GenerationType.AUTO)

   
   @Column(
		name = "cartid"
	)
   
   private int cartID;
   
   @OneToOne(cascade=CascadeType.ALL)
   
   @JoinColumn(name = "productid")
  
   private int productID;
      
   @Column(
		name = "totalcost"
	)

   private double totalCost;
   
   @Column(
		name = "quantity"
	)

   private int quantity;
 
   public cartArray {
   
      quantity = 1-size.cartArray;
      cart = new Product[quantity];
      totalCost = 0.0;
      }
  
  public Cart(){}

	public Cart(int cartID, Product product, double totalCost, int quantity) {
		this.cartID = cartID;
		this.product = product;
		this.totalCost = totalCost;
      this.quantity = quantity;
	}

	public int getCardID() {
		return cartID;
	}

	public Product getProduct() {
		return product;
	}

	public double getTotalCost() {
		return totalcost;
	}

	public int getQuantity() {
		return quantity;
	}
}
