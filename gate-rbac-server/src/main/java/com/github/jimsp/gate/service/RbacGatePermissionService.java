package com.github.jimsp.gate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jimsp.gate.canonial.PermissionCanonico;
import com.github.jimsp.gate.converter.PermissionCanonicoToPermissionConverter;
import com.github.jimsp.gate.converter.PermissionToPermissionCanonicoConverter;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.rbac.entities.Permission;
import com.github.jimsp.gate.rbac.repositories.PermissionJpaRepository;
import com.github.jimsp.gate.remote.RbacGatePermissionRemote;

@Service(GateRmiHandle.RBAC_GATE_PERMISSION_SERVICE)
public class RbacGatePermissionService implements RbacGatePermissionRemote {

	@Autowired
	private PermissionJpaRepository permissionJpaRepository;

	@Autowired
	private PermissionToPermissionCanonicoConverter permissionToPermissionCanonicoConverter;

	@Autowired
	private PermissionCanonicoToPermissionConverter permissionCanonicoToPermissionConverter;

	@Override
	@Transactional
	public void save(final PermissionCanonico permissionCanonico) {
		final Permission permission = permissionCanonicoToPermissionConverter.convert(permissionCanonico);
		permissionJpaRepository.save(permission);
	}

	@Override
	@Transactional
	public void remove(final PermissionCanonico permissionCanonico) {
		permissionJpaRepository.delete(permissionCanonico.getName());
	}

	@Override
	public PermissionCanonico findByName(final PermissionCanonico permissionCanonico) {
		final Permission permission = permissionJpaRepository.findByName(permissionCanonico.getName());
		return permissionToPermissionCanonicoConverter.convert(permission);
	}

	@Override
	public List<PermissionCanonico> findAll() {
		return permissionJpaRepository.findAll() //
				.parallelStream() //
				.map(permission -> permissionToPermissionCanonicoConverter.convert(permission)) //
				.collect(Collectors.toList());
	}
}
