package com.github.jimsp.gate.remote;

import com.github.jimsp.gate.canonial.GroupCanonico;

public interface LdapGateGroupRemote extends CrudGateInterface<GroupCanonico> {

	public GroupCanonico findByValue(final GroupCanonico canonico);
}
