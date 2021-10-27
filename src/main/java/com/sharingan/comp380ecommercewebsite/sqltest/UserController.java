package com.sharingan.comp380ecommercewebsite.sqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}
}
