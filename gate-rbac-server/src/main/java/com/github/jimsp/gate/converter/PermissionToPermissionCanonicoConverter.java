package com.github.jimsp.gate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.OperationCanonico;
import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.rbac.entities.Permission;

@Component("permissionToPermissionCanonicoConverter")
public class PermissionToPermissionCanonicoConverter implements Converter<Permission, PermissionCanonico> {

	@Autowired
	private ResourceToResourceCanonicoConverter resourceToResourceCanonicoConverter;

	@Autowired
	private OperationToOperationCanonicoCoverter operationToOperationCanonicoCoverter;

	@Override
	public PermissionCanonico convert(final Permission permission) {
		final ResourceCanonico resource = resourceToResourceCanonicoConverter.convert(permission.getResource());
		final OperationCanonico operation = operationToOperationCanonicoCoverter.convert(permission.getOperation());
		return PermissionCanonico.create(permission.getName(), permission.getDescription(), operation, resource);
	}
}
