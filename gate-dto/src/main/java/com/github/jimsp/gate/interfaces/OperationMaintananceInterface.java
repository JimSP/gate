package com.github.jimsp.gate.interfaces;

import javax.ws.rs.Path;

import com.github.jimsp.gate.dto.request.OperationRequestDto;
import com.github.jimsp.gate.dto.response.OperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.OPERATION_PATH)
public interface OperationMaintananceInterface extends CrudMaintananceInterface<OperationRequestDto, OperationResponseDto>{

}
