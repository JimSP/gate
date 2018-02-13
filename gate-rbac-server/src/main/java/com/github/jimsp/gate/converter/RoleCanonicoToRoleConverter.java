package com.github.jimsp.gate.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.rbac.entities.Role;

@Component("roleCanonicoToRoleConverter")
public class RoleCanonicoToRoleConverter implements Converter<RoleCanonico, Role> {

	@Autowired
	private PermissionCanonicoToPermissionConverter permissionCanonicoToPermissionConverter;

	@Override
	public Role convert(final RoleCanonico roleCanonico) {
		return new Role( //
				roleCanonico.getName(), //
				roleCanonico.getDescription(), //
				roleCanonico.getAssignable(), //
				roleCanonico.getPermanent(), //
				roleCanonico.getPermissions() //
						.parallelStream() //
						.map(permissionCanonico -> //
						permissionCanonicoToPermissionConverter.convert(permissionCanonico)) //
						.collect(Collectors.toList()), //
				roleCanonico.getChildRoleNames() //
						.parallelStream() //
						.map(roleChildName -> convert(roleChildName)) //
						.collect(Collectors.toList()));
	}
}
