package com.github.jimsp.gate.dto;

public class PermissionDto {

	public static PermissionDto create(final String name, final String description,
			final OperationDto operation, final ResourceDto resource) {
		return new PermissionDto(name, description, operation, resource);
	}

	private final String name;

	private final String description;

	private final Boolean permanent = false;

	private final OperationDto operation;

	private final ResourceDto resource;

	public PermissionDto(final String name, final String description, final OperationDto operation,
			final ResourceDto resource) {
		super();
		this.name = name;
		this.description = description;
		this.operation = operation;
		this.resource = resource;
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

	public OperationDto getOperation() {
		return operation;
	}

	public ResourceDto getResource() {
		return resource;
	}

}
