package com.olix.order_system.domain.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olix.order_system.domain.exception.ModelNotFoundException;
import com.olix.order_system.domain.model.Exit;
import com.olix.order_system.domain.model.ExitItem;
import com.olix.order_system.domain.model.Product;
import com.olix.order_system.domain.repository.ExitItemRepository;
import com.olix.order_system.domain.repository.ExitRepository;

@Service
public class ExitService {
	private ExitRepository exitRepository;
	private ExitItemRepository exitItemRepository;
	private ProductService productService;

	public ExitService(ExitRepository exitRepository, ExitItemRepository exitItemRepository,
			ProductService productService) {
		super();
		this.exitRepository = exitRepository;
		this.exitItemRepository = exitItemRepository;
		this.productService = productService;
	}

	@Transactional
	public void save(Exit exit) {
		exit.setExitDateTime(OffsetDateTime.now());
		this.exitRepository.save(exit);
		for (ExitItem exitItem : exit.getExitItems()) {
			Product hasProduct = this.productService.findById(exitItem.getProduct().getId());
			exitItem.setExit(exit);
			this.exitItemRepository.save(exitItem);
			this.productService.decrementAmount(hasProduct.getId(), exitItem.getAmount());
		}
	}

	public Exit findById(Long id) {
		Optional<Exit> optionalExit = this.exitRepository.findById(id);
		if (optionalExit.isEmpty()) {
			throw new ModelNotFoundException("Exit");
		}
		return optionalExit.get();
	}

	public Page<Exit> findAll(Pageable pageable) {
		return this.exitRepository.findAll(pageable);
	}

}
