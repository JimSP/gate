package com.github.jimsp.gate.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jimsp.gate.entities.Resource;

public interface ResourceJpaRepository extends JpaRepository<Resource, Serializable>{

}
