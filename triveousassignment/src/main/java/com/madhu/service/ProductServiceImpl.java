package com.madhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.dto.ProductDto;
import com.madhu.entity.Product;
import com.madhu.exception.CategoryException;
import com.madhu.exception.ProductException;
import com.madhu.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product addProduct(ProductDto productDto) throws ProductException, CategoryException {

		var product = new Product();

		product.setProductTitle(productDto.getProductTitle());
		product.setProductDescription(productDto.getProductDescription());

		return productRepo.save(product);
	}

	@Override
	public List<Product> getProducts() throws ProductException {
		 
		var products = productRepo.findAll();
		
		if(products.isEmpty())
			throw new ProductException("No Products Found");
		
		
		return products;
	}

	@Override
	public Product getProductByProductId(Integer productId) throws ProductException {
		return productRepo.findById(productId)
				.orElseThrow(()->new ProductException("Product Not Found With Id "+productId));
	}

}
