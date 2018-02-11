package com.github.jimsp.gate.canonial;

public class PermissionCanonico {

	public static PermissionCanonico create(final String name, final String description,
			final OperationCanonico operation, final ResourceCanonico resource) {
		return new PermissionCanonico(name, description, operation, resource);
	}

	private final String name;

	private final String description;

	private final Boolean permanent = false;

	private final OperationCanonico operation;

	private final ResourceCanonico resource;

	public PermissionCanonico(final String name, final String description, final OperationCanonico operation,
			final ResourceCanonico resource) {
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

	public OperationCanonico getOperation() {
		return operation;
	}

	public ResourceCanonico getResource() {
		return resource;
	}

}
