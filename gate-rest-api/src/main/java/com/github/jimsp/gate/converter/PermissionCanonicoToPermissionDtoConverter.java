package com.github.jimsp.gate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.dto.OperationDto;
import com.github.jimsp.gate.dto.PermissionDto;
import com.github.jimsp.gate.dto.ResourceDto;

@Component
public class PermissionCanonicoToPermissionDtoConverter implements Converter<PermissionCanonico, PermissionDto> {

	@Autowired
	private OperationCanonicoToOperationDtoConverter operationCanonicoToOperationDtoConverter;

	@Autowired
	private ResourceCanonicoToResourceDtoConverter resourceCanonicoToResourceDtoConverter;

	@Override
	public PermissionDto convert(final PermissionCanonico permissionCanonico) {
		final OperationDto operation = operationCanonicoToOperationDtoConverter //
				.convert(permissionCanonico //
						.getOperation()); //

		final ResourceDto resource = resourceCanonicoToResourceDtoConverter //
				.convert(permissionCanonico //
						.getResource()); //
		return PermissionDto.create(permissionCanonico.getName(), //
				permissionCanonico.getDescription(), //
				operation, //
				resource);
	}
}
