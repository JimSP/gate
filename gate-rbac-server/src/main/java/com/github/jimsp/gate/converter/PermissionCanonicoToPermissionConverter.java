package com.github.jimsp.gate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.rbac.entities.Operation;
import com.github.jimsp.gate.rbac.entities.Permission;
import com.github.jimsp.gate.rbac.entities.Resource;

@Component("permissionCanonicoToPermissionConverter")
public class PermissionCanonicoToPermissionConverter implements Converter<PermissionCanonico, Permission> {

	@Autowired
	private OperationCanonicoToOperationCoverter operationCanonicoToOperationCoverter;

	@Autowired
	private ResourceCanonicoToResourceConverter resourceCanonicoToResourceConverter;

	@Override
	public Permission convert(final PermissionCanonico permissionCanonico) {
		final Operation operation = operationCanonicoToOperationCoverter.convert(permissionCanonico.getOperation());
		final Resource resource = resourceCanonicoToResourceConverter.convert(permissionCanonico.getResource());
		return new Permission(permissionCanonico.getName(), permissionCanonico.getDescription(),
				permissionCanonico.getPermanent(), operation, resource);
	}
}
