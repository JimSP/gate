package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.rbac.entities.Operation;

@Component("operationToOperationCanonicoCoverter")
public class OperationToOperationCanonicoCoverter implements Converter<Operation, OperationCanonico> {

	@Override
	public OperationCanonico convert(final Operation operation) {
		return OperationCanonico.create(operation.getName(), operation.getDescription(), operation.getPermanent());
	}
}
