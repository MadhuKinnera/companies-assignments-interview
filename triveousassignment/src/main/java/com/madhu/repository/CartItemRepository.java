package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
