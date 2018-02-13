package com.github.jimsp.gate.ldap.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

@Entry(base = "ou=groups", objectClasses = { "person", "inetOrgPerson" })
public final class LdapGateGroup {

	@Id
	private Name dn;

	@Attribute(name = "cn")
	private String name;

	@Attribute(name = "uniqueMember")
	private Set<Name> members;

	public LdapGateGroup() {
	}

	public LdapGateGroup(Name dn, String name, Set<Name> members) {
		this.dn = dn;
		this.name = name;
		this.members = members;
	}

	public Name getDn() {
		return dn;
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}

	public Set<Name> getMembers() {
		return members;
	}

	public void setMembers(Set<Name> members) {
		this.members = members;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addMember(Name member) {
		if (this.members == null) {
			this.members = new HashSet<>();
		}
		members.add(member);
	}

	public void removeMember(Name member) {
		members.remove(member);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dn == null) ? 0 : dn.hashCode());
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
		LdapGateGroup other = (LdapGateGroup) obj;
		if (dn == null) {
			if (other.dn != null)
				return false;
		} else if (!dn.equals(other.dn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "LdapGateGroup [dn=" + dn + ", name=" + name + ", members="
				+ (members != null ? toString(members, maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
}