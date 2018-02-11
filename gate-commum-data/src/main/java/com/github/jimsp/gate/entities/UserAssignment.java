package com.github.jimsp.gate.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

@Entity
public class UserAssignment implements Serializable {

	private static final long serialVersionUID = 8723357490503751923L;

	@Id
	@Column
	private String principal;
	
	@ElementCollection
	@Column
	@OrderColumn(nullable = false)
	@CollectionTable
	private List<String> roleNames;
	
	@Column(nullable = false)
	private Boolean permanent = Boolean.FALSE;

	@Column
	private Date timestamp;

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserAssignment that = (UserAssignment) o;

		return principal.equals(that.principal);

	}

	@Override
	public int hashCode() {
		return principal.hashCode();
	}
}
