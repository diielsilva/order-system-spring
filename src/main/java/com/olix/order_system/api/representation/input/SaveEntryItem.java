package com.olix.order_system.api.representation.input;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveEntryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Amount must not be null")
	@Min(message = "Amount must be equals or bigger than 1", value = 1)
	private Long amount;
	@NotNull
	private Long productId;

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
