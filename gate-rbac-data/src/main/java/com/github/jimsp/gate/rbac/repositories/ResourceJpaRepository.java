package com.github.jimsp.gate.rbac.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.rbac.entities.Resource;

public interface ResourceJpaRepository extends JpaRepository<Resource, Serializable>{

	public Resource findByName(final String name);

}
