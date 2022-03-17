package com.olix.order_system.api.representation.input;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class SaveProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "Name cannot be empty, null or blank")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
