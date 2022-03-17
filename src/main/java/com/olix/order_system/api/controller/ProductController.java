package com.olix.order_system.api.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olix.order_system.api.representation.input.SaveProduct;
import com.olix.order_system.api.representation.input.UpdateProduct;
import com.olix.order_system.api.representation.output.ShowProduct;
import com.olix.order_system.common.mapper.ModelMapper;
import com.olix.order_system.domain.model.Product;
import com.olix.order_system.domain.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	private ProductService productService;
	private ModelMapper modelMapper;

	public ProductController(ProductService productService, ModelMapper modelMapper) {
		super();
		this.productService = productService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid SaveProduct saveProduct) {
		Product productToSave = this.modelMapper.fromSaveProductToProductModel(saveProduct);
		this.productService.save(productToSave);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowProduct> findById(@PathVariable Long id) {
		Product databaseProduct = this.productService.findById(id);
		ShowProduct productToShow = this.modelMapper.fromProductModelToShowProduct(databaseProduct);
		return new ResponseEntity<ShowProduct>(productToShow, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<ShowProduct>> findAll(Pageable pageable) {
		Page<Product> productModelPage = this.productService.findAll(pageable);
		Page<ShowProduct> showProductPage = this.modelMapper.fromProductModelPageToShowProductPage(productModelPage);
		return new ResponseEntity<Page<ShowProduct>>(showProductPage, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateProduct updateProduct) {
		Product producttoUpdate = this.modelMapper.fromUpdateProductToProductModel(updateProduct);
		this.productService.update(id, producttoUpdate);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find")
	public ResponseEntity<Page<ShowProduct>> findByNameContaining(Pageable pageable, String name) {
		Page<Product> productModelPage = this.productService.findByNameContaining(pageable, name);
		Page<ShowProduct> showProductPage = this.modelMapper.fromProductModelPageToShowProductPage(productModelPage);
		return new ResponseEntity<Page<ShowProduct>>(showProductPage, HttpStatus.OK);
	}
}
