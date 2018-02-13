package com.github.jimsp.gate.remote;

import java.util.List;

import com.github.jimsp.gate.canonial.RoleCanonico;


public interface RbacGateUserRolesRemote {

	public List<RoleCanonico> findRoleByToken(final String token);
}
