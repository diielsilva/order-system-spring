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

import com.olix.order_system.api.representation.input.SaveExit;
import com.olix.order_system.api.representation.output.ShowExit;
import com.olix.order_system.common.mapper.ModelMapper;
import com.olix.order_system.domain.model.Exit;
import com.olix.order_system.domain.service.ExitService;

@RestController
@RequestMapping("exits")
public class ExitController {
	private ExitService exitService;
	private ModelMapper modelMapper;

	public ExitController(ExitService exitService, ModelMapper modelMapper) {
		super();
		this.exitService = exitService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid SaveExit saveExit) {
		Exit exitToSave = this.modelMapper.fromSaveExitToExitModel(saveExit);
		this.exitService.save(exitToSave);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowExit> findById(@PathVariable Long id) {
		Exit exit = this.exitService.findById(id);
		ShowExit showExit = this.modelMapper.fromExitModelToShowExit(exit);
		return new ResponseEntity<ShowExit>(showExit, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<ShowExit>> findAll(Pageable pageable) {
		Page<Exit> exitModelPage = this.exitService.findAll(pageable);
		Page<ShowExit> showExitPage = this.modelMapper.fromExitModelPageToShowExitPage(exitModelPage);
		return new ResponseEntity<Page<ShowExit>>(showExitPage, HttpStatus.OK);
	}

}
