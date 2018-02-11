package com.github.jimsp.gate.canonial;

import java.io.Serializable;
import java.util.List;

public class RoleCanonico implements Serializable {

	private static final long serialVersionUID = -146739263594716127L;

	public static RoleCanonico create(final String name, final String description, final Boolean assignable,
			final Boolean permanent, final List<PermissionCanonico> permissions,
			final List<RoleCanonico> childRoleNames) {
		return new RoleCanonico(name, description, assignable, permanent, permissions, childRoleNames);
	}

	private final String name;
	private final String description;
	private final Boolean assignable;
	private final Boolean permanent;
	private final List<PermissionCanonico> permissions;
	private final List<RoleCanonico> childRoleNames;

	public RoleCanonico(final String name, final String description, final Boolean assignable, final Boolean permanent,
			final List<PermissionCanonico> permissions, final List<RoleCanonico> childRoleNames) {
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

	public List<PermissionCanonico> getPermissions() {
		return permissions;
	}

	public List<RoleCanonico> getChildRoleNames() {
		return childRoleNames;
	}
}
