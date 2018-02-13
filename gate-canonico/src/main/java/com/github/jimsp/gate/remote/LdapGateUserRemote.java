package com.github.jimsp.gate.remote;

import com.github.jimsp.gate.canonial.UserCanonico;
public interface LdapGateUserRemote extends CrudGateInterface<UserCanonico>{

	public UserCanonico findByUsername(final UserCanonico userCanonico);

	public UserCanonico findByUsernameAndPassword(final UserCanonico userCanonico);
}
