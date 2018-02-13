package com.github.jimsp.gate.ldap.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(base = "ou=users", objectClasses = { "person", "top" })
public class LdapGateUser implements Serializable {

	private static final long serialVersionUID = -6471764679923241762L;

	@Id
	private Name id;

	@Attribute(name = "cn")
	private String username;

	@Attribute(name = "password")
	private String password;

	@Attribute(name = "roles")
	private String[] roles;

	@DnAttribute(value = "ou")
	private String group;

	public LdapGateUser() {

	}

	public LdapGateUser(final Name id, final String username, final String password, final String... roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Name getId() {
		return id;
	}

	public void setId(Name id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRole(String... roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.toString().hashCode());
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
		LdapGateUser other = (LdapGateUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LdapGateUser [id=" + id + ", username=" + username + ", password="
				+ (password != null ? password.replaceAll(".", "*") : "") + ", roles=" + Arrays.toString(roles) + "]";
	}
}
