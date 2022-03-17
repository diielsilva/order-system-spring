package com.olix.order_system.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olix.order_system.domain.exception.ModelNotFoundException;
import com.olix.order_system.domain.model.Product;
import com.olix.order_system.domain.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Transactional
	public void save(Product product) {
		this.productRepository.save(product);
	}

	public Product findById(Long id) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		return optionalProduct.get();
	}

	public Page<Product> findAll(Pageable pageable) {
		return this.productRepository.findAll(pageable);
	}

	public Page<Product> findByNameContaining(Pageable pageable, String name) {
		return this.productRepository.findByNameContaining(pageable, name);
	}

	@Transactional
	public void update(Long id, Product product) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		optionalProduct.get().setName(product.getName());
		this.productRepository.save(optionalProduct.get());
	}

	@Transactional
	public void incrementAmount(Long id, Long amount) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		Product databaseProduct = optionalProduct.get();
		databaseProduct.setAmount(databaseProduct.getAmount() + amount);
		this.productRepository.save(databaseProduct);
	}

	@Transactional
	public void decrementAmount(Long id, Long amount) {
		Optional<Product> optionalProduct = this.productRepository.findById(id);
		if (optionalProduct.isEmpty()) {
			throw new ModelNotFoundException("Product");
		}
		Product databaseProduct = optionalProduct.get();
		databaseProduct.setAmount(databaseProduct.getAmount() - amount);
		this.productRepository.save(databaseProduct);
	}
}
