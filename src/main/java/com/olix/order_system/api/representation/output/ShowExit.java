package com.olix.order_system.api.representation.output;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowExit implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private OffsetDateTime exitDateTime;
	private List<ShowExitItem> exitItems = new ArrayList<ShowExitItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getExitDateTime() {
		return exitDateTime;
	}

	public void setExitDateTime(OffsetDateTime exitDateTime) {
		this.exitDateTime = exitDateTime;
	}

	public List<ShowExitItem> getExitItems() {
		return exitItems;
	}

	public void setExitItems(List<ShowExitItem> exitItems) {
		this.exitItems = exitItems;
	}

}
