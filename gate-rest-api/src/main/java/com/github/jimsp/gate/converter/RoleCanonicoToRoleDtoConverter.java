package com.github.jimsp.gate.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.dto.PermissionDto;
import com.github.jimsp.gate.dto.RoleDto;

@Component
public class RoleCanonicoToRoleDtoConverter implements Converter<RoleCanonico, RoleDto> {

	@Autowired
	private PermissionCanonicoToPermissionDtoConverter permissionCanonicoToPermissionDtoConverter;

	@Override
	public RoleDto convert(final RoleCanonico roleCanonico) {
		final List<PermissionDto> permissions = roleCanonico //
				.getPermissions() //
				.parallelStream() //
				.map(permission -> permissionCanonicoToPermissionDtoConverter.convert(permission)) //
				.collect(Collectors.toList()); //

		final List<RoleDto> childRoleNames = roleCanonico.getChildRoleNames() //
				.parallelStream() //
				.map(roleChildName -> //
				convert(roleChildName)) //
				.collect(Collectors.toList());

		return RoleDto.create(roleCanonico.getName(), //
				roleCanonico.getDescription(), //
				roleCanonico.getAssignable(), //
				roleCanonico.getPermanent(), //
				permissions, //
				childRoleNames);
	}
}
