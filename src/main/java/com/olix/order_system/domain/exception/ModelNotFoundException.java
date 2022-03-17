package com.olix.order_system.domain.exception;

public class ModelNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String modelName;
	private String message;

	public ModelNotFoundException(String modelName) {
		super();
		this.modelName = modelName;
		this.message = this.modelName + " not found";
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
