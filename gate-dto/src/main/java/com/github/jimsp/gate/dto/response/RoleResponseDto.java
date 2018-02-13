package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.github.jimsp.gate.dto.request.RoleRequestDto;

public class RoleResponseDto implements Serializable{

	private static final long serialVersionUID = 6688749642701131812L;

	public static RoleResponseDto create(final RoleRequestDto roleRequestDto) {
		return new RoleResponseDto(roleRequestDto);
	}

	private final RoleRequestDto roleRequestDto;

	public RoleResponseDto(RoleRequestDto roleRequestDto) {
		super();
		this.roleRequestDto = roleRequestDto;
	}

	public RoleRequestDto getRoleRequestDto() {
		return roleRequestDto;
	}
}
