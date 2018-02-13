package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.github.jimsp.gate.dto.request.OperationRequestDto;

public class OperationResponseDto implements Serializable {

	private static final long serialVersionUID = -1900815666591159051L;

	public static OperationResponseDto create(final OperationRequestDto operationRequestDto) {
		return new OperationResponseDto(operationRequestDto);
	}

	private final OperationRequestDto operationRequestDto;

	public OperationResponseDto(final OperationRequestDto operationRequestDto) {
		super();
		this.operationRequestDto = operationRequestDto;
	}

	public OperationRequestDto getOperationDtoRequest() {
		return operationRequestDto;
	}
}
