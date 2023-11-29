package com.madhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.SaleOrder;

public interface OrderRepository extends JpaRepository<SaleOrder, Integer>{
	
	
	List<SaleOrder> findByUserUserId(Integer userId);

}
