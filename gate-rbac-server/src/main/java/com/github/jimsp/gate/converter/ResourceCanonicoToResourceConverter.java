package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.rbac.entities.Resource;

@Component("resourceCanonicoToResourceConverter")
public class ResourceCanonicoToResourceConverter implements Converter<ResourceCanonico, Resource> {

	@Override
	public Resource convert(final ResourceCanonico resourceCanonico) {
		return new Resource(resourceCanonico.getName(), resourceCanonico.getPattern(),
				resourceCanonico.getPermanent());
	}
}
