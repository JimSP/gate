package com.github.jimsp.gate.interfaces;

import javax.ws.rs.Path;

import com.github.jimsp.gate.dto.request.ResourceRequestDto;
import com.github.jimsp.gate.dto.response.ResourceResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.RESOURCE_PATH)
public interface ResourceMaintananceInterface extends CrudMaintananceInterface<ResourceRequestDto, ResourceResponseDto>{

}
