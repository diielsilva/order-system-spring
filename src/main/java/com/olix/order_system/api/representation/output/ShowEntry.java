package com.olix.order_system.api.representation.output;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowEntry implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private OffsetDateTime entryDateTime;
	private List<ShowEntryItem> entryItems = new ArrayList<ShowEntryItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(OffsetDateTime entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public List<ShowEntryItem> getEntryItems() {
		return entryItems;
	}

	public void setEntryItems(List<ShowEntryItem> entryItems) {
		this.entryItems = entryItems;
	}

}
