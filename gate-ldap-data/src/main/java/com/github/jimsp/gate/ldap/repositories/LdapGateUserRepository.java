package com.github.jimsp.gate.ldap.repositories;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.github.jimsp.gate.ldap.entities.LdapGateUser;

@Repository("ldapGateRepository")
public interface LdapGateUserRepository extends LdapRepository<LdapGateUser>{
	
	public LdapGateUser findByUsername(final String username);
	public LdapGateUser findByUsernameAndPassword(final String username, final String password);

}
