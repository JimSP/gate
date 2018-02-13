package com.github.jimsp.gate.interfaces;

import javax.ws.rs.Path;

import com.github.jimsp.gate.dto.request.PermissionRequestDto;
import com.github.jimsp.gate.dto.response.PermissionResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.PERMISSION_PATH)
public interface PermissionMaintananceInterface extends CrudMaintananceInterface<PermissionRequestDto, PermissionResponseDto>{

}
