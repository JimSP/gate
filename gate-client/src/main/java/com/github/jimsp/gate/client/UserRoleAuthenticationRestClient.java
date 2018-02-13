package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.UserRoleAuthenticationInterface;

public final class UserRoleAuthenticationRestClient {

	protected static UserRoleAuthenticationRestClient create(final String urlGateServer) {
		return new UserRoleAuthenticationRestClient(urlGateServer);
	}
	
	protected static UserRoleAuthenticationRestClient create() {
		return new UserRoleAuthenticationRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final UserRoleAuthenticationInterface userRoleAuthenticationInterface;
	
	private UserRoleAuthenticationRestClient(final String urlGateServer) {
		userRoleAuthenticationInterface = GateClientFactory.createGateInterface(urlGateServer, UserRoleAuthenticationInterface.class);
	}

	public UserOperationResponseDto findByUsernameAndPassword(final UserOperationRequestDto userOperationRequestDto) {
		return userRoleAuthenticationInterface.findByUsernameAndPassword(userOperationRequestDto);
	}

	public List<RoleRequestDto> findByToken(final String token) {
		return userRoleAuthenticationInterface.findByToken(token);
	}
}
