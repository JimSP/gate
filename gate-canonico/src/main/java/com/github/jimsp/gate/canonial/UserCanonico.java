package com.github.jimsp.gate.canonial;

import java.io.Serializable;
import java.util.UUID;

public final class UserCanonico implements Serializable {

	private static final long serialVersionUID = -5530902759627397716L;

	public static UserCanonico create(final String username) {
		return new UserCanonico(null, null, username, null);
	}

	public static UserCanonico create(final String username, final String password) {
		return new UserCanonico(null, null, username, password);
	}

	public static UserCanonico create(final UUID token, final String username, final String password) {
		return new UserCanonico(null, token, username, password);
	}

	public static UserCanonico create(final String id, final UUID token, final String username, final String password) {
		return new UserCanonico(id, token, username, password);
	}

	private final String id;
	private final UUID token;
	private final String username;
	private final String password;
	private final Long loginTimestamp;

	private UserCanonico(final String id, final UUID token, final String username, final String password) {
		super();
		this.id = id;
		this.token = token;
		this.username = username;
		this.password = password;
		this.loginTimestamp = System.currentTimeMillis();
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

	public Long getLoginTimestamp() {
		return loginTimestamp;
	}
}
