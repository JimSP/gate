package com.github.jimsp.gate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.converter.RoleCanonicoToRoleConverter;
import com.github.jimsp.gate.converter.RoleToRoleCanonicoConverter;
import com.github.jimsp.gate.rbac.entities.Role;
import com.github.jimsp.gate.rbac.repositories.RoleJpaRepository;
import com.github.jimsp.gate.remote.RbacGateRoleRemote;

@Service
public class RbacGateRoleService implements RbacGateRoleRemote {

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	private RoleToRoleCanonicoConverter roleToRoleCanonicoConverter;

	@Autowired
	private RoleCanonicoToRoleConverter roleCanonicoToRoleConverter;

	@Override
	@Transactional
	public void save(final RoleCanonico roleCanonico) {
		final Role role = roleCanonicoToRoleConverter.convert(roleCanonico);
		roleJpaRepository.save(role);
	}

	@Override
	@Transactional
	public void remove(final RoleCanonico roleCanonico) {
		roleJpaRepository.delete(roleCanonico.getName());
	}

	@Override
	public RoleCanonico findByName(final RoleCanonico roleCanonico) {
		final Role role = roleJpaRepository.findByName(roleCanonico.getName());
		return roleToRoleCanonicoConverter.convert(role);
	}

	@Override
	public List<RoleCanonico> findAll() {
		return roleJpaRepository.findAll() //
				.parallelStream() //
				.map(role -> roleToRoleCanonicoConverter.convert(role)) //
				.collect(Collectors.toList());
	}
}
