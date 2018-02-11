package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.dto.OperationDto;

@Component
public class OperationCanonicoToOperationDtoConverter implements Converter<OperationCanonico, OperationDto> {

	@Override
	public OperationDto convert(final OperationCanonico operationCanonico) {
		return OperationDto.create(operationCanonico.getName(), operationCanonico.getDescription(),
				operationCanonico.getPermanent());
	}
}
