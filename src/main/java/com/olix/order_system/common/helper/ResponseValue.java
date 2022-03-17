package com.olix.order_system.common.helper;

import java.io.Serializable;

public class ResponseValue implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;

	public ResponseValue(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
