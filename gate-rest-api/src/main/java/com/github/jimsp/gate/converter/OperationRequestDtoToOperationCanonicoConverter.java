package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.dto.request.OperationRequestDto;

@Component("operationRequestDtoToOperationCanonicoConverter")
public class OperationRequestDtoToOperationCanonicoConverter implements Converter<OperationRequestDto, OperationCanonico> {

	@Override
	public OperationCanonico convert(final OperationRequestDto operationRequestDto) {
		return new OperationCanonico(operationRequestDto.getName(), operationRequestDto.getDescription(),
				operationRequestDto.getPermanent());
	}
}
