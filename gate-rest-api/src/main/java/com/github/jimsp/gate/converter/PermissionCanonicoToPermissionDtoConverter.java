package com.github.jimsp.gate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.dto.request.OperationRequestDto;
import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.request.ResourceRequestDto;

@Component("permissionCanonicoToPermissionDtoConverter")
public class PermissionCanonicoToPermissionDtoConverter implements Converter<PermissionCanonico, PermissionRequestDto> {

	@Autowired
	private OperationCanonicoToOperationDtoConverter operationCanonicoToOperationDtoConverter;

	@Autowired
	private ResourceCanonicoToResourceDtoConverter resourceCanonicoToResourceDtoConverter;

	@Override
	public PermissionRequestDto convert(final PermissionCanonico permissionCanonico) {
		final OperationRequestDto operation = operationCanonicoToOperationDtoConverter //
				.convert(permissionCanonico //
						.getOperation()); //

		final ResourceRequestDto resource = resourceCanonicoToResourceDtoConverter //
				.convert(permissionCanonico //
						.getResource()); //
		return PermissionRequestDto.create(permissionCanonico.getName(), permissionCanonico.getDescription(),
				permissionCanonico.getPermanent(), operation, resource);
	}
}
