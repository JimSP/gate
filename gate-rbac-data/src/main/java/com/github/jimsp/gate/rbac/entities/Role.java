package com.github.jimsp.gate.rbac.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = -8353258401305690073L;

	@Id
	@Column
	private String name;

	@Column
	private String description;

	@Column(nullable = false)
	private Boolean assignable = Boolean.FALSE;

	@Column(nullable = false)
	private Boolean permanent = Boolean.FALSE;

	@ManyToMany
	private List<Permission> permissions;

	@ManyToMany
	private List<Role> childRoleNames;

	public Role() {

	}

	public Role(String name, String description, Boolean assignable, Boolean permanent, List<Permission> permissions,
			List<Role> childRoleNames) {
		super();
		this.name = name;
		this.description = description;
		this.assignable = assignable;
		this.permanent = permanent;
		this.permissions = permissions;
		this.childRoleNames = childRoleNames;
	}

	public List<Role> getChildRoleNames() {
		return childRoleNames;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public boolean isAssignable() {
		return assignable;
	}

	public void setAssignable(boolean assignable) {
		this.assignable = assignable;
	}

	public void setChildRoleNames(List<Role> names) {
		this.childRoleNames = names;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		Role role = (Role) o;
		return name.equals(role.name);

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
