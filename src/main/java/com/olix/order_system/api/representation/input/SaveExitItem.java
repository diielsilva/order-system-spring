package com.olix.order_system.api.representation.input;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveExitItem implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@Min(message = "Amount must be equals or bigger than 1", value = 1)
	private Long amount;
	@NotNull
	private Long productId;

	public SaveExitItem() {

	}

	public SaveExitItem(Long amount, Long productId) {
		super();
		this.amount = amount;
		this.productId = productId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
