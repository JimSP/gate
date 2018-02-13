package com.github.jimsp.gate.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationRequestDto implements Serializable {

	private static final long serialVersionUID = 2023353663119510489L;

	public static OperationRequestDto create(final String name, final String description, final Boolean permanent) {
		return new OperationRequestDto(name, description, permanent);
	}

	@NotBlank(message = "name invalid value, expected not blank or not null.")
	@Size(min = 6, max = 15, message = "name invalid size, expected min=6, max=15.")
	private final String name;

	@NotBlank(message = "description invalid value, expected not blank or not null.")
	@Size(min = 1, max = 25, message = "description invalid size, expected min=1, max=25.")
	private final String description;

	@NotNull(message = "permanent invalid value, expected true or false.")
	private final Boolean permanent;

	@JsonCreator
	public OperationRequestDto(@JsonProperty("name") final String name,
			@JsonProperty("description") final String description, @JsonProperty("permanent") final Boolean permanent) {
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
