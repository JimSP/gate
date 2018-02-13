package com.github.jimsp.gate.dto.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleRequestDto implements Serializable {

	private static final long serialVersionUID = -146739263594716127L;

	public static RoleRequestDto create(final String name, final String description, final Boolean assignable,
			final Boolean permanent, final List<PermissionRequestDto> permissions,
			final List<RoleRequestDto> childRoleNames) {
		return new RoleRequestDto(name, description, assignable, permanent, permissions, childRoleNames);
	}

	@NotBlank(message = "name invalid value, expected not blank or not null.")
	@Size(min = 6, max = 15, message = "name invalid size, expected min=6, max=15.")
	private final String name;
	
	@NotBlank(message = "description invalid value, expected not blank or not null.")
	@Size(min = 1, max = 25, message = "name invalid size, expected min=1, max=25.")
	private final String description;
	
	@NotNull(message = "assignable invalid value, expected true or false.")
	private final Boolean assignable;
	
	@NotNull(message = "permanent invalid value, expected true or false.")
	private final Boolean permanent;
	
	private final List<PermissionRequestDto> permissions;
	
	private final List<RoleRequestDto> childRoleNames;

	@JsonCreator
	public RoleRequestDto(@JsonProperty("name") final String name,
			@JsonProperty("description") final String description, 
			@JsonProperty("assignable") final Boolean assignable,
			@JsonProperty("permanent") final Boolean permanent,
			@JsonProperty("permissions") final List<PermissionRequestDto> permissions,
			@JsonProperty("childRoleNames") final List<RoleRequestDto> childRoleNames) {
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

	public List<PermissionRequestDto> getPermissions() {
		return permissions;
	}

	public List<RoleRequestDto> getChildRoleNames() {
		return childRoleNames;
	}
}
