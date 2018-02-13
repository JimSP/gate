package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.UserMaintenanceInterface;

public final class UserMaintananceRestClient {
	
	protected static UserMaintananceRestClient create(final String urlGateServer) {
		return new UserMaintananceRestClient(urlGateServer);
	}
	
	protected static UserMaintananceRestClient create() {
		return new UserMaintananceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}

	private final UserMaintenanceInterface userMaintenanceInterface;

	private UserMaintananceRestClient(final String urlGateServer) {
		userMaintenanceInterface = GateClientFactory.createGateInterface(urlGateServer, UserMaintenanceInterface.class);
	}

	public UserOperationResponseDto save(final UserOperationRequestDto request) {
		return userMaintenanceInterface.save(request);
	}

	public UserOperationResponseDto remove(final UserOperationRequestDto request) {
		return userMaintenanceInterface.remove(request);
	}

	public List<String> findAll() {
		return userMaintenanceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return userMaintenanceInterface.existName(name);
	}
}
