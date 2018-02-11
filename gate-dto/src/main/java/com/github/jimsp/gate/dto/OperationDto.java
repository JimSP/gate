package com.github.jimsp.gate.dto;

import java.io.Serializable;

public class OperationDto implements Serializable {

	private static final long serialVersionUID = 2023353663119510489L;

	public static OperationDto create(final String name, final String description, final Boolean permanent) {
		return new OperationDto(name, description, permanent);
	}

	private final String name;

	private final String description;

	private final Boolean permanent;

	public OperationDto(final String name, final String description, final Boolean permanent) {
		super();
		this.name = name;
		this.description = description;
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getPermanent() {
		return permanent;
	}
}
