package com.sharingan.comp380ecommercewebsite.sqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public User findById(int id) {
		return userRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
