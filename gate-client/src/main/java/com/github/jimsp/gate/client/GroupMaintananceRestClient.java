package com.github.jimsp.gate.client;

import java.util.List;

import com.github.jimsp.gate.dto.request.GroupOperationRequestDto;
import com.github.jimsp.gate.dto.response.GroupOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;
import com.github.jimsp.gate.interfaces.GroupMaintananceInterface;

public final class GroupMaintananceRestClient {
	
	protected static GroupMaintananceRestClient create(final String urlGateServer) {
		return new GroupMaintananceRestClient(urlGateServer);
	}
	
	protected static GroupMaintananceRestClient create() {
		return new GroupMaintananceRestClient(GateRestHandle.HTTP_LOCALHOST_8080);
	}
	
	private final GroupMaintananceInterface groupMaintananceInterface;

	private GroupMaintananceRestClient(final String urlGateServer) {
		groupMaintananceInterface = GateClientFactory.createGateInterface(urlGateServer, GroupMaintananceInterface.class);
	}

	public GroupOperationResponseDto save(final GroupOperationRequestDto request) {
		return groupMaintananceInterface.save(request);
	}

	public GroupOperationResponseDto remove(final GroupOperationRequestDto request) {
		return groupMaintananceInterface.remove(request);
	}

	public List<String> findAll() {
		return groupMaintananceInterface.findAll();
	}

	public Boolean existName(final String name) {
		return groupMaintananceInterface.existName(name);
	}

	public Boolean existValue(final String groupValue) {
		return groupMaintananceInterface.existValue(groupValue);
	}
}
