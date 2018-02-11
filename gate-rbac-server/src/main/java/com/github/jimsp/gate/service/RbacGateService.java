package com.github.jimsp.gate.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jimsp.gate.canonial.RoleCanonico;
import com.github.jimsp.gate.canonial.UserCanonico;
import com.github.jimsp.gate.canonial.exceptions.TokenExpireException;
import com.github.jimsp.gate.converter.RoleToRoleCanonicoConverter;
import com.github.jimsp.gate.entities.UserAssignment;
import com.github.jimsp.gate.remote.RbacGateRemote;
import com.github.jimsp.gate.repositories.RoleJpaRepository;
import com.github.jimsp.gate.repositories.UserAssignmentJpaRepository;
import com.hazelcast.core.IMap;

@Service
public class RbacGateService implements RbacGateRemote {

	@Autowired
	private IMap<String, UserCanonico> userCanonicoStore;

	@Autowired
	private UserAssignmentJpaRepository userAssignmentJpaRepository;

	@Autowired
	private RoleJpaRepository roleJpaRepository;

	@Autowired
	private RoleToRoleCanonicoConverter roleCanonicoConverter;

	public List<RoleCanonico> findRolesByToken(final String token) {
		final UserCanonico userCanonico = userCanonicoStore.get(token);
		
		if (userCanonico != null) {
			if(userCanonico.getLoginTimestamp().longValue() > TimeUnit.MINUTES.toMillis(20)) {
				userCanonicoStore.remove(userCanonico.getUsername());
				throw new TokenExpireException();
			}else {
				final UserAssignment userAssignment = userAssignmentJpaRepository
						.findByPrincipal(userCanonico.getUsername());

				return roleJpaRepository //
						.findByRoleNames(userAssignment.getRoleNames()) //
						.parallelStream() //
						.map(role -> roleCanonicoConverter.convert(role)) //
						.collect(Collectors.toList());
			}
		} else {
			return Collections.emptyList();
		}
	}
}
