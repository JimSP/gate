package com.github.jimsp.gate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.LdapGateUserToUserCanonicoConverter;
import com.github.jimsp.gate.converter.UserCanonicoToLdapGateUserConverter;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.ldap.entities.LdapGateUser;
import com.github.jimsp.gate.ldap.repositories.LdapGateUserRepository;
import com.github.jimsp.gate.remote.LdapGateUserRemote;
import com.hazelcast.core.IMap;

@Service(GateRmiHandle.LDPA_GATE_USER_SERVICE)
public class LdapGateUserService implements LdapGateUserRemote {

	@Autowired
	@Qualifier("ldapGateRepository")
	private LdapGateUserRepository ldapGateUserRepository;

	@Autowired
	private LdapGateUserToUserCanonicoConverter ldapGateUserToUserCanonicoConverter;

	@Autowired
	private UserCanonicoToLdapGateUserConverter userCanonicoToLdapGateUserConverter;

	@Autowired
	private IMap<String, UserCanonico> userCanonicoStore;

	@Transactional
	public void save(final UserCanonico userCanonico) {
		final LdapGateUser ldapGateUser = userCanonicoToLdapGateUserConverter.convert(userCanonico);
		ldapGateUserRepository.save(ldapGateUser);
	}

	@Transactional
	public void remove(final UserCanonico userCanonico) {
		final LdapGateUser ldapGateUser = userCanonicoToLdapGateUserConverter.convert(userCanonico);
		ldapGateUserRepository.delete(ldapGateUser);
	}

	public List<UserCanonico> findAll() {
		final List<UserCanonico> userCanonicos = new ArrayList<>();

		ldapGateUserRepository //
				.findAll() //
				.forEach(ldapGateUser -> { //
					final UserCanonico userCanonico = ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
					userCanonicos.add(userCanonico);
				});

		return userCanonicos;
	}

	public UserCanonico findByUsername(final UserCanonico userCanonico) {
		return findByName(userCanonico);
	}

	public UserCanonico findByName(final UserCanonico userCanonico) {
		try {
			final LdapGateUser ldapGateUser = ldapGateUserRepository.findByUsername(userCanonico.getUsername());
			return ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
		} catch (Exception e) {
			return UserCanonico.empty();
		}
	}

	public UserCanonico findByUsernameAndPassword(final UserCanonico userCanonico) {
		try {
			final UserCanonico userCanonicoStored = userCanonicoStore.get(userCanonico.getUsername());
			return Optional.ofNullable(userCanonicoStored).orElse(createUUIDAndStoreUserCanonico(userCanonico));
		} catch (Exception e) {
			return null;
		}
	}

	private UserCanonico createUUIDAndStoreUserCanonico(final UserCanonico userCanonico) {
		final LdapGateUser ldapGateUser = ldapGateUserRepository.findByUsernameAndPassword(userCanonico.getUsername(),
				userCanonico.getPassword());
		final UserCanonico userCanonicoSaved = ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
		userCanonicoStore.put(userCanonicoSaved.getUsername(),
				UserCanonico.create(UUID.randomUUID(), userCanonicoSaved.getUsername(), userCanonicoSaved.getPassword(),
						userCanonico.getRoles(), System.currentTimeMillis()));
		return userCanonicoSaved;
	}
}
