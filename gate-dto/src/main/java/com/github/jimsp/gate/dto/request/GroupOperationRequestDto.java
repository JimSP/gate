package com.github.jimsp.gate.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupOperationRequestDto implements Serializable {

	private static final long serialVersionUID = -3151752852707936484L;

	public static GroupOperationRequestDto create(final String name, final String value) {
		return new GroupOperationRequestDto(name, value);
	}

	@NotBlank(message = "name invalid value, expected not blank or not null. ")
	@Size(min = 2, max = 2, message = "name invalid size, expected length=2.")
	private final String name;

	@NotBlank(message = "name invalid value, expected not blank or not null. ")
	@Size(min = 2, max = 9, message = "name invalid size, expected min=3 and max=9.")
	private final String value;

	@JsonCreator
	public GroupOperationRequestDto(@JsonProperty("name") final String name,
			@JsonProperty("value") final String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "GroupDto [name=" + name + ", value=" + value + "]";
	}

}
