package com.github.jimsp.gate.rbac.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.rbac.entities.Permission;

public interface PermissionJpaRepository extends JpaRepository<Permission, Serializable>{

	public Permission findByName(final String name);

}
