package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.dto.request.ResourceRequestDto;

@Component("resourceCanonicoToResourceDtoConverter")
public class ResourceCanonicoToResourceDtoConverter implements Converter<ResourceCanonico, ResourceRequestDto> {

	@Override
	public ResourceRequestDto convert(final ResourceCanonico resourceCanonico) {
		return ResourceRequestDto.create( //
				resourceCanonico.getName(), //
				resourceCanonico.getPattern(), //
				resourceCanonico.getPattern());
	}
}
