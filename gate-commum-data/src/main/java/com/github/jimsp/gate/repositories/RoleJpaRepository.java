package com.github.jimsp.gate.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.github.jimsp.gate.entities.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Serializable> {

	public List<Role> findByRoleNames(@Param("roleNames") final List<String> roleNames);

}
