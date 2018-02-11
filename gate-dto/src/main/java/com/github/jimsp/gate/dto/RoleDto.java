package com.github.jimsp.gate.dto;

import java.io.Serializable;
import java.util.List;

public class RoleDto implements Serializable {

	private static final long serialVersionUID = -146739263594716127L;

	public static RoleDto create(final String name, final String description, final Boolean assignable,
			final Boolean permanent, final List<PermissionDto> permissions,
			final List<RoleDto> childRoleNames) {
		return new RoleDto(name, description, assignable, permanent, permissions, childRoleNames);
	}

	private final String name;
	private final String description;
	private final Boolean assignable;
	private final Boolean permanent;
	private final List<PermissionDto> permissions;
	private final List<RoleDto> childRoleNames;

	public RoleDto(final String name, final String description, final Boolean assignable, final Boolean permanent,
			final List<PermissionDto> permissions, final List<RoleDto> childRoleNames) {
		super();
		this.name = name;
		this.description = description;
		this.assignable = assignable;
		this.permanent = permanent;
		this.permissions = permissions;
		this.childRoleNames = childRoleNames;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getAssignable() {
		return assignable;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	public List<PermissionDto> getPermissions() {
		return permissions;
	}

	public List<RoleDto> getChildRoleNames() {
		return childRoleNames;
	}
}
