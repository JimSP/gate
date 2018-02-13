package com.github.jimsp.gate.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.dto.request.RoleRequestDto;

@Component("roleRequestDtoToRoleCanonicoConverter")
public class RoleRequestDtoToRoleCanonicoConverter implements Converter<RoleRequestDto, RoleCanonico> {

	@Autowired
	private PermissionRequestDtoToPermissionCanonicoConverter permissionRequestDtoToPermissionCanonicoConverter;

	@Override
	public RoleCanonico convert(final RoleRequestDto roleRequestDto) {

		return RoleCanonico.create(roleRequestDto.getName(), roleRequestDto.getDescription(),
				roleRequestDto.getAssignable(), roleRequestDto.getPermanent(), roleRequestDto //
						.getPermissions() //
						.parallelStream() //
						.map( //
								permissionRequestDto -> permissionRequestDtoToPermissionCanonicoConverter
										.convert(permissionRequestDto)) //
						.collect(Collectors.toList()),
				roleRequestDto //
						.getChildRoleNames() //
						.parallelStream() //
						.map(childRoleName -> convert(childRoleName)) //
						.collect(Collectors.toList()));
	}

}
