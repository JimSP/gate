package com.github.jimsp.gate.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.request.RoleRequestDto;

@Component("roleCanonicoToRoleDtoConverter")
public class RoleCanonicoToRoleDtoConverter implements Converter<RoleCanonico, RoleRequestDto> {

	@Autowired
	private PermissionCanonicoToPermissionDtoConverter permissionCanonicoToPermissionDtoConverter;

	@Override
	public RoleRequestDto convert(final RoleCanonico roleCanonico) {
		final List<PermissionRequestDto> permissions = roleCanonico //
				.getPermissions() //
				.parallelStream() //
				.map(permission -> permissionCanonicoToPermissionDtoConverter.convert(permission)) //
				.collect(Collectors.toList()); //

		final List<RoleRequestDto> childRoleNames = roleCanonico.getChildRoleNames() //
				.parallelStream() //
				.map(roleChildName -> //
				convert(roleChildName)) //
				.collect(Collectors.toList());

		return RoleRequestDto.create(roleCanonico.getName(), //
				roleCanonico.getDescription(), //
				roleCanonico.getAssignable(), //
				roleCanonico.getPermanent(), //
				permissions, //
				childRoleNames);
	}
}
