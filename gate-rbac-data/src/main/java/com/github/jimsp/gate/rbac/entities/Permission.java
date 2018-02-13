package com.github.jimsp.gate.rbac.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Permission implements Serializable {

	private static final long serialVersionUID = 9106210316267101072L;

	@Id
	@Column
	private String name;

	@Column
	private String description;

	@Column(nullable = false)
	private Boolean permanent = Boolean.FALSE;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Operation operation;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Resource resource;

	public Permission() {
		
	}
	
	public Permission(String name, String description, Boolean permanent, Operation operation, Resource resource) {
		super();
		this.name = name;
		this.description = description;
		this.permanent = permanent;
		this.operation = operation;
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	public void setPermanent(Boolean permanent) {
		this.permanent = permanent;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
