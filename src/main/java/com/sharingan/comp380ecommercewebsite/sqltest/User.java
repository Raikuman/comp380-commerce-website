package com.sharingan.comp380ecommercewebsite.sqltest;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (
		name = "userid"
	)
	private int userId;

	@Column (
		name = "firstname"
	)
	private String firstName;

	@Column (
		name = "lastname"
	)
	private String lastName;

	@Column (
		name = "email"
	)
	private String email;

	@Column (
		name = "password"
	)
	private String password;

	public User() {}

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
