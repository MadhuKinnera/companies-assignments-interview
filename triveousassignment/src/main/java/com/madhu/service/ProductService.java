package com.madhu.service;

import java.util.List;

import com.madhu.dto.ProductDto;
import com.madhu.entity.Product;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;

public interface ProductService {

	Product addProduct(ProductDto productDto) throws ProductException, CategoryException;

	List<Product> getProducts() throws ProductException;

	Product getProductByProductId(Integer productId) throws ProductException;

}
