package com.github.jimsp.gate.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.ldap.entities.LdapGateUser;

@Component("ldapGateUserToUserCanonicoConverter")
public class LdapGateUserToUserCanonicoConverter implements Converter<LdapGateUser, UserCanonico> {

	@Override
	public UserCanonico convert(final LdapGateUser ldapGateUser) {
		final List<RoleCanonico> roleCanonicoList = //
				Arrays.asList(ldapGateUser.getRoles())//
						.parallelStream()//
						.map(role -> RoleCanonico.create(role, //
								null, //
								null, //
								null, //
								null, //
								null))
						.collect(Collectors.toList());

		return UserCanonico.create( //
				ldapGateUser.getUsername(), //
				ldapGateUser.getPassword(), //
				roleCanonicoList, //
				null);
	}
}
