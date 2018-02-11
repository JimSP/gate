package com.github.jimsp.gate.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.entities.Role;

@Component
public class RoleToRoleCanonicoConverter implements Converter<Role, RoleCanonico> {

	@Autowired
	private PermissionToPermissionCanonicoConverter permissionToPermissionCanonicoConverter;

	@Override
	public RoleCanonico convert(final Role role) {
		return RoleCanonico //
				.create(role.getName(), //
						role.getDescription(), //
						role.isAssignable(), //
						role.isPermanent(), //
						role //
								.getPermissions() //
								.parallelStream() //
								.map(permission -> permissionToPermissionCanonicoConverter //
										.convert(permission)) //
								.collect(Collectors.toList()), //
						role //
								.getChildRoleNames() //
								.parallelStream() //
								.map(roleChild -> convert(roleChild)) //
								.collect(Collectors.toList()));
	}
}
