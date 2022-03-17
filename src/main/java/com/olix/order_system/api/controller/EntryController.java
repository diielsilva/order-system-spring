package com.olix.order_system.api.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olix.order_system.api.representation.input.SaveEntry;
import com.olix.order_system.api.representation.output.ShowEntry;
import com.olix.order_system.common.mapper.ModelMapper;
import com.olix.order_system.domain.model.Entry;
import com.olix.order_system.domain.service.EntryService;

@RestController
@RequestMapping("entries")
public class EntryController {
	private EntryService entryService;
	private ModelMapper modelMapper;

	public EntryController(EntryService entryService, ModelMapper modelMapper) {
		super();
		this.entryService = entryService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid SaveEntry saveEntry) {
		Entry entry = this.modelMapper.fromSaveEntryToEntryModel(saveEntry);
		this.entryService.save(entry);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowEntry> findById(@PathVariable Long id) {
		Entry entry = this.entryService.findById(id);
		ShowEntry showEntry = this.modelMapper.fromEntryModelToShowEntry(entry);
		return new ResponseEntity<ShowEntry>(showEntry, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<ShowEntry>> findAll(Pageable pageable) {
		Page<Entry> entryModelPage = this.entryService.findAll(pageable);
		Page<ShowEntry> showEntryPage = this.modelMapper.fromEntryModelPageToShowEntryPage(entryModelPage);
		return new ResponseEntity<Page<ShowEntry>>(showEntryPage, HttpStatus.OK);
	}
}
