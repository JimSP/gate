package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.model.LdapGateUser;

@Component("ldapGateUserToUserCanonicoConverter")
public class LdapGateUserToUserCanonicoConverter implements Converter<LdapGateUser, UserCanonico> {

	@Override
	public UserCanonico convert(final LdapGateUser ldapGateUser) {
		return UserCanonico.create(ldapGateUser.getUsername(), ldapGateUser.getPassword());
	}
}
