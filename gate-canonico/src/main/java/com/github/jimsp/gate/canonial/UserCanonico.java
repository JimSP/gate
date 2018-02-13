package com.github.jimsp.gate.canonial;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class UserCanonico implements Serializable {

	private static final long serialVersionUID = -5530902759627397716L;
	

	public static UserCanonico empty() {
		return new UserCanonico(null, null, null, null, null, null);
	}

	public static UserCanonico create(final String username, final Long loginTimestamp) {
		return new UserCanonico(null, null, username, null, null, loginTimestamp);
	}

	public static UserCanonico create(final String username, final String password, final List<RoleCanonico> roles,
			final Long loginTimestamp) {
		return new UserCanonico(null, null, username, password, roles, loginTimestamp);
	}

	public static UserCanonico create(final UUID token, final String username, final String password,
			final List<RoleCanonico> roles, final Long loginTimestamp) {
		return new UserCanonico(null, token, username, password, roles, loginTimestamp);
	}

	public static UserCanonico create(final String id, final UUID token, final String username, final String password,
			final List<RoleCanonico> roles, final Long loginTimestamp) {
		return new UserCanonico(id, token, username, password, roles, loginTimestamp);
	}

	private final String id;
	private final UUID token;
	private final String username;
	private final String password;
	private final List<RoleCanonico> roles;
	private final Long loginTimestamp;

	private UserCanonico(final String id, final UUID token, final String username, final String password,
			final List<RoleCanonico> roles, final Long loginTimestamp) {
		super();
		this.id = id;
		this.token = token;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.loginTimestamp = loginTimestamp;
	}

	public String getId() {
		return id;
	}

	public UUID getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<RoleCanonico> getRoles() {
		return roles;
	}

	public Long getLoginTimestamp() {
		return loginTimestamp;
	}

	@Override
	public String toString() {
		return "UserCanonico [id=" + id + ", token=" + token + ", username=" + username + ", password="
				+ (password != null ? password.replaceAll(".", "*") : "") + ", roles=" + Arrays.toString(roles != null ? roles.toArray() : new String[] {}) + ", loginTimestamp=" + loginTimestamp + "]";
	}
}
