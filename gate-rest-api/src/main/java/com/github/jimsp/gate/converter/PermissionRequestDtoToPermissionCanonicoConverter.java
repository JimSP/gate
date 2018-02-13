package com.github.jimsp.gate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.dto.request.OperationRequestDto;
import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.request.ResourceRequestDto;

@Component("permissionRequestDtoToPermissionCanonicoConverter")
public class PermissionRequestDtoToPermissionCanonicoConverter
		implements Converter<PermissionRequestDto, PermissionCanonico> {

	@Autowired
	private OperationRequestDtoToOperationCanonicoConverter operationRequestDtoToOperationCanonicoConverter;

	@Autowired
	private ResourceRequestDtoToResourceCanonicoConverter resourceRequestDtoToResourceCanonicoConverter;

	@Override
	public PermissionCanonico convert(final PermissionRequestDto permissionRequestDto) {

		final OperationRequestDto operationRequestDto = permissionRequestDto.getOperation();
		final ResourceRequestDto resourceRequestDto = permissionRequestDto.getResource();

		final OperationCanonico operationCanonico = operationRequestDtoToOperationCanonicoConverter
				.convert(operationRequestDto);
		final ResourceCanonico resourceCanonico = resourceRequestDtoToResourceCanonicoConverter
				.convert(resourceRequestDto);

		return PermissionCanonico.create(permissionRequestDto.getName(), permissionRequestDto.getDescription(),
				operationCanonico, resourceCanonico);
	}

}
