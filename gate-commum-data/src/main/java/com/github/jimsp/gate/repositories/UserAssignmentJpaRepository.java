package com.github.jimsp.gate.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.github.jimsp.gate.entities.UserAssignment;

public interface UserAssignmentJpaRepository extends JpaRepository<UserAssignment, Serializable>{

	public UserAssignment findByPrincipal(@Param("pricipal") final String pricipal);

}
