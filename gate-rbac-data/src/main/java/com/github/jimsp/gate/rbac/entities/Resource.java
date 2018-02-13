package com.github.jimsp.gate.rbac.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource implements Serializable {

	private static final long serialVersionUID = 2149695107454448703L;

	@Id
	@Column
	private String name;

	@Column(nullable = false)
	private Boolean pattern = Boolean.FALSE;

	@Column(nullable = false)
	private Boolean permanent = Boolean.FALSE;

	public Resource() {

	}

	public Resource(String name, Boolean pattern, Boolean permanent) {
		super();
		this.name = name;
		this.pattern = pattern;
		this.permanent = permanent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPattern() {
		return pattern;
	}

	public void setPattern(Boolean pattern) {
		this.pattern = pattern;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	public void setPermanent(Boolean permanent) {
		this.permanent = permanent;
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
		Resource other = (Resource) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
