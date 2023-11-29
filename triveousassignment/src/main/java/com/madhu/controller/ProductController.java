package com.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.dto.ProductDto;
import com.madhu.entity.Product;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;
import com.madhu.service.ProductService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/product")
@SecurityRequirement(name = "scheme1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto) throws ProductException, CategoryException {

		return ResponseEntity.ok(productService.addProduct(productDto));
	}

	@GetMapping("/getProducts")
	ResponseEntity<List<Product>> getProducts() throws ProductException {

		return ResponseEntity.ok(productService.getProducts());
	}

	@GetMapping("/getProductById/{productId}")
	ResponseEntity<Product> getProductByProductId(@PathVariable Integer productId) throws ProductException {
		return ResponseEntity.ok(productService.getProductByProductId(productId));
	}

}
