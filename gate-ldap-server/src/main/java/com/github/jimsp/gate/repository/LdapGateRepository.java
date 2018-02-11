package com.github.jimsp.gate.repository;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.github.jimsp.gate.model.LdapGateUser;

@Repository("ldapGateRepository")
public interface LdapGateRepository extends LdapRepository<LdapGateUser>{
	
	public LdapGateUser findByUsername(final String username);
	public LdapGateUser findByUsernameAndPassword(final String username, final String password);

}
