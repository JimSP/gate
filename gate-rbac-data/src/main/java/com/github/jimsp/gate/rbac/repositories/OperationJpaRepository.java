package com.github.jimsp.gate.rbac.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.rbac.entities.Operation;

public interface OperationJpaRepository extends JpaRepository<Operation, Serializable>{

	public Operation findByName(final String name);

}
