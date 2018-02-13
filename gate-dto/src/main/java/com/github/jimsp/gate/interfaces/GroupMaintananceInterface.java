package com.github.jimsp.gate.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.jimsp.gate.dto.request.GroupOperationRequestDto;
import com.github.jimsp.gate.dto.response.GroupOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.GROUP_PATH)
public interface GroupMaintananceInterface extends CrudMaintananceInterface<GroupOperationRequestDto, GroupOperationResponseDto> {
	
	@GET
	@Path("/{groupValue}/existValue")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean existValue(@PathParam("groupValue") final String groupValue);

}
