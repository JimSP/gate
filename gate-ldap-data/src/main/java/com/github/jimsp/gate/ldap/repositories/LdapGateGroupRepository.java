package com.github.jimsp.gate.ldap.repositories;

import javax.naming.Name;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.github.jimsp.gate.ldap.entities.LdapGateGroup;

@Repository("ldapGateGroupRepository")
public interface LdapGateGroupRepository extends LdapRepository<LdapGateGroup> {

	public LdapGateGroup findByDn(final Name name);
	public LdapGateGroup findByName(final String value);

}
