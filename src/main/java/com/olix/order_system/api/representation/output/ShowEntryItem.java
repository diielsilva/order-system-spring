package com.olix.order_system.api.representation.output;

import java.io.Serializable;

public class ShowEntryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long amount;
	private ShowProduct product;

	public ShowEntryItem() {

	}

	public ShowEntryItem(Long id, Long amount, ShowProduct product) {
		super();
		this.id = id;
		this.amount = amount;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public ShowProduct getProduct() {
		return product;
	}

	public void setProduct(ShowProduct product) {
		this.product = product;
	}

}
