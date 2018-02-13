package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;

public class UserOperationResponseDto implements Serializable{

	private static final long serialVersionUID = 544656422855647718L;

	public static UserOperationResponseDto create(final UserOperationRequestDto userAuthenticationRequestDto, //
			final String token) {
		return new UserOperationResponseDto(userAuthenticationRequestDto, token);
	}

	private final UserOperationRequestDto userAuthenticationRequestDto;
	private final String token;

	@JsonCreator
	public UserOperationResponseDto( //
			@JsonProperty("userAuthenticationRequestDto") final UserOperationRequestDto userAuthenticationRequestDto, //
			@JsonProperty("token") final String token) {
		
		super();
		this.userAuthenticationRequestDto = userAuthenticationRequestDto;
		this.token = token;
	}

	public UserOperationRequestDto getUserAuthenticationRequestDto() {
		return userAuthenticationRequestDto;
	}

	public String getToken() {
		return token;
	}

}
