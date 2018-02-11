package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.dto.ResourceDto;

@Component
public class ResourceCanonicoToResourceDtoConverter implements Converter<ResourceCanonico, ResourceDto> {

	@Override
	public ResourceDto convert(final ResourceCanonico resourceCanonico) {
		return ResourceDto.create( //
				resourceCanonico.getIdentifier(), //
				resourceCanonico.getPattern(), //
				resourceCanonico.getPattern());
	}
}
