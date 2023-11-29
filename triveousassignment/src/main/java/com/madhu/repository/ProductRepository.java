package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
