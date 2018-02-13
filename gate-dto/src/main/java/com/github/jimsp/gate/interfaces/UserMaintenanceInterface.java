package com.github.jimsp.gate.interfaces;

import javax.ws.rs.Path;

import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.USER_PATH)
public interface UserMaintenanceInterface extends CrudMaintananceInterface<UserOperationRequestDto, UserOperationResponseDto>{

}
