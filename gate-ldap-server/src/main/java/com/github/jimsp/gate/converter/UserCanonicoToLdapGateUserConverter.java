package com.github.jimsp.gate.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Component;

import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.model.LdapGateUser;

@Component
public class UserCanonicoToLdapGateUserConverter implements Converter<UserCanonico, LdapGateUser> {

	@Override
	public LdapGateUser convert(final UserCanonico userCanonico) {
		return new LdapGateUser(LdapUtils.newLdapName(userCanonico.getId()), userCanonico.getUsername(),
				userCanonico.getPassword());
	}

}
