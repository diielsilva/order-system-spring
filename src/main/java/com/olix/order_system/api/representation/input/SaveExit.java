package com.olix.order_system.api.representation.input;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SaveExit implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Exit items must not be empty or null")
	@Valid
	private List<SaveExitItem> exitItems;

	public List<SaveExitItem> getExitItems() {
		return exitItems;
	}

	public void setExitItems(List<SaveExitItem> exitItems) {
		this.exitItems = exitItems;
	}

}
