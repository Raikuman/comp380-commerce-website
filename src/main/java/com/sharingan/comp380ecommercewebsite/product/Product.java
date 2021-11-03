package com.sharingan.comp380ecommercewebsite.product;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		name = "productid"
	)
	private int id;

	@Column(
		name = "name"
	)
	private String name;

	@Column(
		name = "price"
	)
	private double price;

	@Column(
		name = "imageurl"
	)
	private String imageUrl;

	public Product(){}

	public Product(String name, double price, String imageUrl) {
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
