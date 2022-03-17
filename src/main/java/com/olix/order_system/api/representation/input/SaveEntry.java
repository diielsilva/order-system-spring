package com.olix.order_system.api.representation.input;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SaveEntry implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Entry items must not be empty or null")
	@Valid
	private List<SaveEntryItem> entryItems;

	public List<SaveEntryItem> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems(List<SaveEntryItem> entryItems) {
		this.entryItems = entryItems;
	}

}
