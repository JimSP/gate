package com.github.jimsp.gate.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserOperationRequestDto {
	
	public static UserOperationRequestDto create(final String username, //
			final String password) {
		return new UserOperationRequestDto(username, password);
	}

	@NotBlank(message="username invalid value, expected not blank or not null.")
	@Size(min=6, max=15, message="username invalid size, expected min=6, max=15")
	private final String username;
	
	@NotBlank
	@Size(min=6, max=25, message="password invalid size, expected min=6, max=25")
	private final String password;

	@JsonCreator
	public UserOperationRequestDto(//
			@JsonProperty(value = "username") final String username, //
			@JsonProperty(value = "password") final String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
