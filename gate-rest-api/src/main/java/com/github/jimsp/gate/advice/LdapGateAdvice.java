package com.github.jimsp.gate.advice;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.jimsp.gate.canonial.exceptions.TokenExpireException;
import com.github.jimsp.gate.dto.RoleDto;
import com.github.jimsp.gate.dto.UserOperationResponseDto;
import com.github.jimsp.gate.dto.exception.UserNotFoundException;
import com.github.jimsp.gate.dto.exception.UserNotRemovedException;
import com.github.jimsp.gate.dto.exception.UserNotSaveException;

@RestControllerAdvice
public class LdapGateAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Service Unavailable")
	public UserOperationResponseDto error(final UserNotFoundException userNotFoundException) {
		return UserOperationResponseDto.create(null, null);
	}

	@ExceptionHandler(UserNotSaveException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Forbidden")
	public UserOperationResponseDto error(final UserNotSaveException userNotSaveException) {
		return UserOperationResponseDto.create(null, null);
	}

	@ExceptionHandler(UserNotRemovedException.class)
	@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Service Unavailable")
	public UserOperationResponseDto error(final UserNotRemovedException userNotSaveException) {
		return UserOperationResponseDto.create(null, null);
	}

	@ExceptionHandler(TokenExpireException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Token Exceeded Time")
	public List<RoleDto> error(final TokenExpireException tokenExpireException) {
		return Collections.emptyList();
	}
}
