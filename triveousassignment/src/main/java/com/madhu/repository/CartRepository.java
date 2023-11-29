package com.madhu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	
 Optional<Cart> findByUserUserId(Integer userId);

}
