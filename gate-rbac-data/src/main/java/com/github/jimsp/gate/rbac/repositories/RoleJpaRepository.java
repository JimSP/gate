package com.github.jimsp.gate.rbac.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.rbac.entities.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Serializable> {

	public Role findByRoleName(final String roleName);

	public Role findByName(final String name);

}
