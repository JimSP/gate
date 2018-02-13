package com.github.jimsp.gate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jimsp.gate.canonial.ResourceCanonico;
import com.github.jimsp.gate.converter.ResourceCanonicoToResourceConverter;
import com.github.jimsp.gate.converter.ResourceToResourceCanonicoConverter;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.rbac.entities.Resource;
import com.github.jimsp.gate.rbac.repositories.ResourceJpaRepository;
import com.github.jimsp.gate.remote.RbacGateResourceRemote;

@Service(GateRmiHandle.RBAC_GATE_RESOURCE_SERVICE)
public class RbacGateResourceService implements RbacGateResourceRemote {

	@Autowired
	private ResourceJpaRepository resourceJpaRepository;

	@Autowired
	private ResourceToResourceCanonicoConverter resourceToResourceCanonicoConverter;

	@Autowired
	private ResourceCanonicoToResourceConverter resourceCanonicoToResourceConverter;

	@Override
	@Transactional
	public void save(final ResourceCanonico resourceCanonico) {
		final Resource resource = resourceCanonicoToResourceConverter.convert(resourceCanonico);
		resourceJpaRepository.save(resource);
	}

	@Override
	@Transactional
	public void remove(final ResourceCanonico resourceCanonico) {
		resourceJpaRepository.delete(resourceCanonico.getName());
	}

	@Override
	public ResourceCanonico findByName(final ResourceCanonico resourceCanonico) {
		final Resource resource = resourceJpaRepository.findByName(resourceCanonico.getName());
		return resourceToResourceCanonicoConverter.convert(resource);
	}

	@Override
	public List<ResourceCanonico> findAll() {
		return resourceJpaRepository.findAll() //
				.parallelStream() //
				.map(resource -> resourceToResourceCanonicoConverter.convert(resource)) //
				.collect(Collectors.toList());
	}
}
