package com.github.jimsp.gate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.LdapGateUserToUserCanonicoConverter;
import com.github.jimsp.gate.converter.UserCanonicoToLdapGateUserConverter;
import com.github.jimsp.gate.model.LdapGateUser;
import com.github.jimsp.gate.remote.LdpaGateRemote;
import com.github.jimsp.gate.repository.LdapGateRepository;
import com.hazelcast.core.IMap;

@Service("ldpaGateService")
public class LdpaGateService implements LdpaGateRemote {

	@Autowired
	@Qualifier("ldapGateRepository")
	private LdapGateRepository ldapGateRepository;

	@Autowired
	private LdapGateUserToUserCanonicoConverter ldapGateUserToUserCanonicoConverter;

	@Autowired
	private UserCanonicoToLdapGateUserConverter userCanonicoToLdapGateUserConverter;

	@Autowired
	private IMap<String, UserCanonico> userCanonicoStore;

	public Boolean save(final UserCanonico userCanonico) {
		final LdapGateUser ldapGateUser = userCanonicoToLdapGateUserConverter.convert(userCanonico);
		final LdapGateUser newLdapGateUser = ldapGateRepository.save(ldapGateUser);
		return newLdapGateUser != null && userCanonico.getUsername().equals(newLdapGateUser.getUsername())
				&& userCanonico.getPassword().equals(newLdapGateUser.getPassword());
	}

	public Boolean remove(final UserCanonico userCanonico) {
		final LdapGateUser ldapGateUser = userCanonicoToLdapGateUserConverter.convert(userCanonico);
		ldapGateRepository.delete(ldapGateUser);
		return findByUsername(userCanonico) == null;
	}

	public List<UserCanonico> findAll() {
		final List<UserCanonico> userCanonicos = new ArrayList<>();

		ldapGateRepository //
				.findAll().forEach(ldapGateUser -> { //
					final UserCanonico userCanonico = ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
					userCanonicos.add(userCanonico);
				});

		return userCanonicos;
	}

	public UserCanonico findByUsername(final UserCanonico userCanonico) {
		try {
			final LdapGateUser ldapGateUser = ldapGateRepository.findByUsername(userCanonico.getUsername());
			return ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
		} catch (Exception e) {
			return null;
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
		final LdapGateUser ldapGateUser = ldapGateRepository.findByUsernameAndPassword(userCanonico.getUsername(),
				userCanonico.getPassword());
		final UserCanonico userCanonicoSaved = ldapGateUserToUserCanonicoConverter.convert(ldapGateUser);
		userCanonicoStore.put(userCanonicoSaved.getUsername(), UserCanonico.create(UUID.randomUUID(),
				userCanonicoSaved.getUsername(), userCanonicoSaved.getPassword()));
		return userCanonicoSaved;
	}
}
