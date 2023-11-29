package com.madhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entity.Category;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;
import com.madhu.repository.CategoryRepository;
import com.madhu.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Category addCategory(String categoryName) throws CategoryException {
		var category = new Category();

		category.setCategoryName(categoryName);

		return categoryRepo.save(category);
	}

	@Override
	public Category addProductToCategory(Integer categoryId, Integer productId)
			throws CategoryException, ProductException {
		var category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryException("Category Not Found with Id " + categoryId));

		var product = productService.getProductByProductId(productId);

		category.getProducts().add(product);
		
		productRepo.save(product);
		
		product.setCategory(category);

	
		return categoryRepo.save(category);

	}

	@Override
	public List<Category> getCategories() throws CategoryException {
		var categories = categoryRepo.findAll();

		if (categories.isEmpty())
			throw new CategoryException(" No Categories Found ");

		return categories;
	}

}
