package com.madhu.service;

import java.util.List;

import com.madhu.entity.Expense;
import com.madhu.exceptions.ExpenseException;

public interface ExpenseService {
	
	Expense addExpense(Expense expense) throws ExpenseException;

	Expense getExpenseById(Long id) throws ExpenseException;

	List<Expense> getExpensesByDestination(Long destinationId) throws ExpenseException;
}
