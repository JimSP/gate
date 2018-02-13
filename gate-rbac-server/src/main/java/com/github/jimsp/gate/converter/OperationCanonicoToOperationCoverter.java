package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.rbac.entities.Operation;

@Component("operationCanonicoToOperationCoverter")
public class OperationCanonicoToOperationCoverter implements Converter<OperationCanonico, Operation> {

	@Override
	public Operation convert(final OperationCanonico operationCanonico) {
		return new Operation(operationCanonico.getName(), operationCanonico.getDescription(),
				operationCanonico.getPermanent());
	}
}
