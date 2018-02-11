package com.github.jimsp.gate.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.entities.Permission;

public interface PermissionJpaRepository extends JpaRepository<Permission, Serializable>{

}
