package com.madhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhu.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
