package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.response.RoleResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.RoleMaintananceInterface;

public final class RoleMaintenanceRestClient {

	protected static RoleMaintenanceRestClient create(final String urlGateServer) {
		return new RoleMaintenanceRestClient(urlGateServer);
	}
	
	protected static RoleMaintenanceRestClient create() {
		return new RoleMaintenanceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final RoleMaintananceInterface roleMaintananceInterface;

	private RoleMaintenanceRestClient(final String urlGateServer) {
		roleMaintananceInterface = GateClientFactory.createGateInterface(urlGateServer, RoleMaintananceInterface.class);
	}

	public RoleResponseDto save(final RoleRequestDto request) {
		return roleMaintananceInterface.save(request);
	}

	public RoleResponseDto remove(final RoleRequestDto request) {
		return roleMaintananceInterface.remove(request);
	}

	public List<String> findAll() {
		return roleMaintananceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return roleMaintananceInterface.existName(name);
	}
}
