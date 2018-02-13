package com.github.jimsp.gate.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.converter.RoleToRoleCanonicoConverter;
import com.github.jimsp.gate.exceptions.TokenExpireException;
import com.github.jimsp.gate.handle.GateRmiHandle;
import com.github.jimsp.gate.rbac.repositories.RoleJpaRepository;
import com.github.jimsp.gate.remote.RbacGateUserRolesRemote;
import com.hazelcast.core.IMap;

@Service(GateRmiHandle.RBAC_GATE_USER_ROLES_SERVICE)
public class RbacGateUserRolesService implements RbacGateUserRolesRemote {

	@Autowired
	private IMap<String, UserCanonico> userCanonicoStore;

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	private RoleToRoleCanonicoConverter roleToRoleCanonicoConverter;

	@Override
	public List<RoleCanonico> findRoleByToken(final String token) {
		final UserCanonico userCanonico = userCanonicoStore.get(token);

		if (userCanonico != null) {
			if (userCanonico.getLoginTimestamp().longValue() > TimeUnit.MINUTES.toMillis(20)) {
				userCanonicoStore.remove(userCanonico.getUsername());
				throw new TokenExpireException();
			} else {
				return userCanonico.getRoles().parallelStream().map(role -> roleJpaRepository //
						.findByName(role.getName())) //
						.map(role -> roleToRoleCanonicoConverter.convert(role)).collect(Collectors.toList());
			}
		} else {
			return Collections.emptyList();
		}
	}
}
