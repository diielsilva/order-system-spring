package com.olix.order_system.api.representation.output;

import java.io.Serializable;

public class ShowExitItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long amount;
	private ShowProduct showProduct;

	public ShowExitItem() {

	}

	public ShowExitItem(Long id, Long amount, ShowProduct showProduct) {
		super();
		this.id = id;
		this.amount = amount;
		this.showProduct = showProduct;
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

	public ShowProduct getShowProduct() {
		return showProduct;
	}

	public void setShowProduct(ShowProduct showProduct) {
		this.showProduct = showProduct;
	}

}
