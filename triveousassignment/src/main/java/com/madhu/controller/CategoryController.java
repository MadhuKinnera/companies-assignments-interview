package com.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.entity.Category;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;
import com.madhu.service.CategoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/category")
@SecurityRequirement(name = "scheme1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addCategory/{categoryName}")
	ResponseEntity<Category> addCategory(@PathVariable String categoryName) throws CategoryException {

		return ResponseEntity.ok(categoryService.addCategory(categoryName));

	}

	@PutMapping("/addProductToCategory/{categoryId}/{productId}")
	ResponseEntity<Category> addProductToCategory(@PathVariable Integer categoryId,@PathVariable Integer productId)
			throws CategoryException, ProductException {
		return ResponseEntity.ok(categoryService.addProductToCategory(categoryId, productId));
	}

	@GetMapping("/getCategories")
	ResponseEntity<List<Category>> getCategories() throws CategoryException {
		return ResponseEntity.ok(categoryService.getCategories());
	}

}
