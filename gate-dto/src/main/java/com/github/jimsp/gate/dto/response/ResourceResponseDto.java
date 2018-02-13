package com.github.jimsp.gate.dto.response;

import java.io.Serializable;

import com.github.jimsp.gate.dto.request.ResourceRequestDto;

public class ResourceResponseDto implements Serializable {

	private static final long serialVersionUID = 1127479957301662307L;

	public static ResourceResponseDto create(final ResourceRequestDto resourceRequestDto) {
		return new ResourceResponseDto(resourceRequestDto);
	}

	private final ResourceRequestDto resourceRequestDto;

	public ResourceResponseDto(ResourceRequestDto resourceRequestDto) {
		super();
		this.resourceRequestDto = resourceRequestDto;
	}

	public ResourceRequestDto getResourceRequestDto() {
		return resourceRequestDto;
	}
}
