package com.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.entity.Expense;
import com.madhu.exceptions.ExpenseException;
import com.madhu.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/addExpense")
    public Expense addExpense(@RequestBody Expense expense) throws ExpenseException {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/getExpenseById/{id}")
    public Expense getExpenseById(@PathVariable Long id) throws ExpenseException {
        return expenseService.getExpenseById(id);
    }

    @GetMapping("/getExpenseByDestination/{destinationId}")
    public List<Expense> getExpensesByDestination(@PathVariable Long destinationId) throws ExpenseException {
        return expenseService.getExpensesByDestination(destinationId);
    }
}
