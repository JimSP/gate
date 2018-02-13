package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.dto.request.OperationRequestDto;

@Component("operationCanonicoToOperationDtoConverter")
public class OperationCanonicoToOperationDtoConverter implements Converter<OperationCanonico, OperationRequestDto> {

	@Override
	public OperationRequestDto convert(final OperationCanonico operationCanonico) {
		return OperationRequestDto.create(operationCanonico.getName(), operationCanonico.getDescription(),
				operationCanonico.getPermanent());
	}
}
