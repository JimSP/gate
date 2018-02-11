package com.github.jimsp.gate.remote;

import java.util.List;

import com.github.jimsp.gate.canonial.RoleCanonico;


public interface RbacGateRemote {

	public List<RoleCanonico> findRolesByToken(final String token);
}
