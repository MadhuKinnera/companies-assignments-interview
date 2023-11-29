package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
