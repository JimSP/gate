package com.github.jimsp.gate.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.github.jimsp.gate.canonial.GroupCanonico;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.ldap.entities.LdapGateGroup;
import com.github.jimsp.gate.ldap.repositories.LdapGateGroupRepository;
import com.github.jimsp.gate.remote.LdapGateGroupRemote;

@Service(GateRmiHandle.LDAP_GATE_GROUP_SERVICE)
public class LdapGateGroupService implements LdapGateGroupRemote {

	@Autowired
	@Qualifier("ldapGateGroupRepository")
	private LdapGateGroupRepository ldapGateGroupRepository;

	@Override
	public void save(final GroupCanonico canonico) {
		final LdapGateGroup ldapGateGroup = null;
		ldapGateGroupRepository.save(ldapGateGroup);
	}

	@Override
	public void remove(final GroupCanonico canonico) {
		final Name id = null;
		ldapGateGroupRepository.delete(id);
	}

	@Override
	public GroupCanonico findByName(final GroupCanonico canonico) {
		final LdapGateGroup ldapGateGroup = ldapGateGroupRepository.findByDn(LdapUtils.newLdapName(canonico.getName()));
		return GroupCanonico.create(ldapGateGroup.getDn().getAll());
	}

	@Override
	public GroupCanonico findByValue(final GroupCanonico canonico) {
		final LdapGateGroup ldapGateGroup = ldapGateGroupRepository.findByName(canonico.getValue());
		return GroupCanonico.create(ldapGateGroup.getDn().getAll());
	}

	@Override
	public List<GroupCanonico> findAll() {
		final List<GroupCanonico> group = new ArrayList<>();
		ldapGateGroupRepository //
				.findAll() //
				.forEach(ldapGateGroup -> { //
					group.add( //
							GroupCanonico.create(ldapGateGroup.getDn().getAll())); //
				});
		return group;
	}
}
