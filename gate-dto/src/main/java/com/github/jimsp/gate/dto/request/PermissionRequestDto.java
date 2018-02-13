package com.github.jimsp.gate.dto.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PermissionRequestDto implements Serializable{

	private static final long serialVersionUID = -4249582231712184313L;

	public static PermissionRequestDto create(final String name,
			final String description,
			final Boolean permanent,
			final OperationRequestDto operation,
			final ResourceRequestDto resource) {
		return new PermissionRequestDto(name, description, permanent, operation, resource);
	}

	@NotBlank(message = "name invalid value, expected not blank or not null.")
	@Size(min = 6, max = 15, message = "name invalid size, expected min=6, max=15.")
	private final String name;

	@NotBlank(message = "description invalid value, expected not blank or not null.")
	@Size(min = 1, max = 25, message = "name invalid size, expected min=1, max=25.")
	private final String description;

	@NotNull(message = "permanent invalid value, expected true or false.")
	private final Boolean permanent;

	@Valid
	private final OperationRequestDto operation;

	@Valid
	private final ResourceRequestDto resource;

	@JsonCreator
	public PermissionRequestDto(
			@JsonProperty("name") final String name,
			@JsonProperty("description") final String description,
			@JsonProperty("permanent") final Boolean permanent,
			@JsonProperty("operation") final OperationRequestDto operation,
			@JsonProperty("resource") final ResourceRequestDto resource) {
		super();
		this.name = name;
		this.description = description;
		this.permanent = permanent;
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

	public OperationRequestDto getOperation() {
		return operation;
	}

	public ResourceRequestDto getResource() {
		return resource;
	}
}
