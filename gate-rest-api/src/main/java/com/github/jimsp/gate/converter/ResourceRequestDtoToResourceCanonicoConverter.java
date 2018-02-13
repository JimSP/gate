package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.dto.request.ResourceRequestDto;

@Component("resourceRequestDtoToResourceCanonicoConverter")
public class ResourceRequestDtoToResourceCanonicoConverter implements Converter<ResourceRequestDto, ResourceCanonico> {

	@Override
	public ResourceCanonico convert(final ResourceRequestDto resourceRequestDto) {
		return ResourceCanonico.create(resourceRequestDto.getName(), resourceRequestDto.getPattern(),
				resourceRequestDto.getPermanent());
	}
}
