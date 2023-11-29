package com.madhu.service;

import java.util.List;

import com.madhu.entity.Category;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;

public interface CategoryService {

	Category addCategory(String categoryName) throws CategoryException;

	Category addProductToCategory(Integer categoryId, Integer productId) throws CategoryException, ProductException;

	List<Category> getCategories() throws CategoryException;

}
