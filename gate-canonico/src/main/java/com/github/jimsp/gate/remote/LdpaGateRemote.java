package com.github.jimsp.gate.remote;

import java.util.List;

import com.github.jimsp.gate.canonial.UserCanonico;
public interface LdpaGateRemote {
	
	public Boolean save(final UserCanonico userCanonico);

	public Boolean remove(final UserCanonico userCanonico);

	public List<UserCanonico> findAll();

	public UserCanonico findByUsername(final UserCanonico userCanonico);

	public UserCanonico findByUsernameAndPassword(final UserCanonico userCanonico);
}
