package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.ResourceRequestDto;
import com.github.jimsp.gate.dto.response.ResourceResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.ResourceMaintananceInterface;

public final class ResourceMaintenanceRestClient {

	protected static ResourceMaintenanceRestClient create(final String urlGateServer) {
		return new ResourceMaintenanceRestClient(urlGateServer);
	}
	
	protected static ResourceMaintenanceRestClient create() {
		return new ResourceMaintenanceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final ResourceMaintananceInterface resourceMaintananceInterface;

	private ResourceMaintenanceRestClient(final String urlGateServer) {
		resourceMaintananceInterface = GateClientFactory.createGateInterface(urlGateServer, ResourceMaintananceInterface.class);
	}

	public ResourceResponseDto save(final ResourceRequestDto request) {
		return resourceMaintananceInterface.save(request);
	}

	public ResourceResponseDto remove(final ResourceRequestDto request) {
		return resourceMaintananceInterface.remove(request);
	}

	public List<String> findAll() {
		return resourceMaintananceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return resourceMaintananceInterface.existName(name);
	}
}
