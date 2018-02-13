package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.github.jimsp.gate.dto.request.PermissionRequestDto;

public class PermissionResponseDto implements Serializable{

	private static final long serialVersionUID = -7041679051658355255L;

	public static PermissionResponseDto create(final PermissionRequestDto permissionRequestDto) {
		return new PermissionResponseDto(permissionRequestDto);
	}
	
	private final PermissionRequestDto permissionRequestDto;

	public PermissionResponseDto(PermissionRequestDto permissionRequestDto) {
		super();
		this.permissionRequestDto = permissionRequestDto;
	}

	public PermissionRequestDto getPermissionRequestDto() {
		return permissionRequestDto;
	}
}
