package com.madhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entity.Expense;
import com.madhu.exceptions.ExpenseException;
import com.madhu.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) throws ExpenseException {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseException("Expense not found with id: " + id));
    }

    @Override
    public List<Expense> getExpensesByDestination(Long destinationId) throws ExpenseException {
        var expenses =  expenseRepository.findByDestinationId(destinationId);
        
        if(expenses.isEmpty())
        	throw new ExpenseException("No Expenses Found");
        
        return expenses;
    }
}
