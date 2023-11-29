package com.madhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDestinationId(Long destinationId);
    
    
}
