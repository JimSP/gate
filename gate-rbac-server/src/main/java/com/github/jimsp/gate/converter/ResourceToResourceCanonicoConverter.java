package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.rbac.entities.Resource;

@Component("resourceToResourceCanonicoConverter")
public class ResourceToResourceCanonicoConverter implements Converter<Resource, ResourceCanonico> {

	@Override
	public ResourceCanonico convert(final Resource resource) {
		return ResourceCanonico.create(resource.getName(), resource.getPattern(), resource.getPermanent());
	}
}
