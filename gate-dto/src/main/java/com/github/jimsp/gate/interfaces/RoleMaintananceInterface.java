package com.github.jimsp.gate.interfaces;

import javax.ws.rs.Path;

import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.response.RoleResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.ROLE_PATH)
public interface RoleMaintananceInterface extends CrudMaintananceInterface<RoleRequestDto, RoleResponseDto> {

}