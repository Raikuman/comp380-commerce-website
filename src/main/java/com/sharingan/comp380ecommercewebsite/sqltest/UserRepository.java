package com.sharingan.comp380ecommercewebsite.sqltest;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
