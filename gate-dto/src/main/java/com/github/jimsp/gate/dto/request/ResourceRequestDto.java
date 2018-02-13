package com.github.jimsp.gate.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceRequestDto implements Serializable {

	private static final long serialVersionUID = -786542488741654550L;

	public static ResourceRequestDto create(final String name, final Boolean pattern, final Boolean permanent) {
		return new ResourceRequestDto(name, pattern, permanent);
	}

	@NotBlank(message = "name invalid value, expected not blank or not null.")
	@Size(min = 6, max = 15, message = "name invalid size, expected min=6, max=15.")
	private final String name;
	
	@NotNull(message = "pattern invalid value, expected true or false.")
	private final Boolean pattern;
	
	@NotNull(message = "permanent invalid value, expected true or false.")
	private final Boolean permanent;

	@JsonCreator
	public ResourceRequestDto(
			@JsonProperty("name") final String name,
			@JsonProperty("pattern") final Boolean pattern,
			@JsonProperty("permanent") final Boolean permanent) {
		super();
		this.name = name;
		this.pattern = pattern;
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public Boolean getPattern() {
		return pattern;
	}

	public Boolean getPermanent() {
		return permanent;
	}
}
