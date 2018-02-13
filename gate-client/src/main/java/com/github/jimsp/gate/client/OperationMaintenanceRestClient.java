package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.OperationRequestDto;
import com.github.jimsp.gate.dto.response.OperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.OperationMaintananceInterface;

public final class OperationMaintenanceRestClient {
	
	protected static OperationMaintenanceRestClient create(final String urlGateServer) {
		return new OperationMaintenanceRestClient(urlGateServer);
	}
	
	protected static OperationMaintenanceRestClient create() {
		return new OperationMaintenanceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final OperationMaintananceInterface operationMaintananceInterface;

	private OperationMaintenanceRestClient(final String urlGateServer) {
		operationMaintananceInterface = GateClientFactory.createGateInterface(urlGateServer, OperationMaintananceInterface.class);
	}

	public OperationResponseDto save(final OperationRequestDto request) {
		return operationMaintananceInterface.save(request);
	}

	public OperationResponseDto remove(final OperationRequestDto request) {
		return operationMaintananceInterface.remove(request);
	}

	public List<String> findAll() {
		return operationMaintananceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return operationMaintananceInterface.existName(name);
	}
}
