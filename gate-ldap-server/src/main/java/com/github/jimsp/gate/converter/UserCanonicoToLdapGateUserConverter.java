package com.github.jimsp.gate.converter;

import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.ldap.entities.LdapGateUser;

@Component
public class UserCanonicoToLdapGateUserConverter implements Converter<UserCanonico, LdapGateUser> {

	@Override
	public LdapGateUser convert(final UserCanonico userCanonico) {

		return new LdapGateUser( //
				LdapUtils //
						.newLdapName( //
								userCanonico.getId()), //
				userCanonico.getUsername(), //
				userCanonico.getPassword(), //
				userCanonico.getRoles() //
						.parallelStream() //
						.map(mapper -> mapper.getName()) //
						.collect(Collectors.toList()) //
						.toArray(new String[userCanonico.getRoles().size()]));
	}

}
