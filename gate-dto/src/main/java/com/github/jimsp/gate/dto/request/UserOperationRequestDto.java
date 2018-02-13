package com.github.jimsp.gate.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserOperationRequestDto implements Serializable{

	private static final long serialVersionUID = 6281317717096826204L;

	public static UserOperationRequestDto create(final String username, //
			final String password, final Date createDate) {
		return new UserOperationRequestDto(username, password, createDate);
	}

	@NotBlank(message = "username invalid value, expected not blank or not null.")
	@Size(min = 6, max = 15, message = "username invalid size, expected min=6, max=15.")
	private final String username;

	@NotBlank
	@Size(min = 6, max = 25, message = "password invalid size, expected min=6, max=25.")
	private final String password;

	@NotNull(message = "createDate invalid value, expected not null")
	private final Date createDate;

	@JsonCreator
	public UserOperationRequestDto(//
			@JsonProperty(value = "username") final String username, //
			@JsonProperty(value = "password") final String password,
			@JsonProperty(value = "createDate") final Date createDate) {
		this.username = username;
		this.password = password;
		this.createDate = createDate;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreateDate() {
		return createDate;
	}
}
