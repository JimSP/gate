package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.response.PermissionResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.PermissionMaintananceInterface;

public final class PermissionMaintenanceRestClient {

	protected static PermissionMaintenanceRestClient create(final String urlGateServer) {
		return new PermissionMaintenanceRestClient(urlGateServer);
	}
	
	protected static PermissionMaintenanceRestClient create() {
		return new PermissionMaintenanceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final PermissionMaintananceInterface permissionMaintananceInterface;

	private PermissionMaintenanceRestClient(final String urlGateServer) {
		permissionMaintananceInterface = GateClientFactory.createGateInterface(urlGateServer, PermissionMaintananceInterface.class);
	}

	public PermissionResponseDto save(final PermissionRequestDto request) {
		return permissionMaintananceInterface.save(request);
	}

	public PermissionResponseDto remove(final PermissionRequestDto request) {
		return permissionMaintananceInterface.remove(request);
	}

	public List<String> findAll() {
		return permissionMaintananceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return permissionMaintananceInterface.existName(name);
	}
}
