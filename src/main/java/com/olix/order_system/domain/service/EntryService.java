package com.olix.order_system.domain.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.olix.order_system.domain.exception.ModelNotFoundException;
import com.olix.order_system.domain.model.Entry;
import com.olix.order_system.domain.model.EntryItem;
import com.olix.order_system.domain.model.Product;
import com.olix.order_system.domain.repository.EntryItemRepository;
import com.olix.order_system.domain.repository.EntryRepository;

@Repository
public class EntryService {
	private EntryItemRepository entryItemRepository;
	private EntryRepository entryRepository;
	private ProductService productService;

	public EntryService(EntryItemRepository entryItemRepository, EntryRepository entryRepository,
			ProductService productService) {
		super();
		this.entryItemRepository = entryItemRepository;
		this.entryRepository = entryRepository;
		this.productService = productService;
	}

	@Transactional
	public void save(Entry entry) {
		entry.setEntryDateTime(OffsetDateTime.now());
		this.entryRepository.save(entry);
		for (EntryItem entryItem : entry.getEntryItems()) {
			Product hasProduct = this.productService.findById(entryItem.getProduct().getId());
			entryItem.setEntry(entry);
			this.entryItemRepository.save(entryItem);
			this.productService.incrementAmount(hasProduct.getId(), entryItem.getAmount());
		}
	}

	public Entry findById(Long id) {
		Optional<Entry> optionalEntry = this.entryRepository.findById(id);
		if (optionalEntry.isEmpty()) {
			throw new ModelNotFoundException("Entry");
		}
		return optionalEntry.get();
	}

	public Page<Entry> findAll(Pageable pageable) {
		return this.entryRepository.findAll(pageable);
	}

}
