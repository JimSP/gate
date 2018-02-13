package com.github.jimsp.gate.interfaces;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.jimsp.gate.dto.request.RoleRequestDto;
import com.github.jimsp.gate.dto.request.UserOperationRequestDto;
import com.github.jimsp.gate.dto.response.UserOperationResponseDto;
import com.github.jimsp.gate.hadle.GateRestHandle;

@Path(GateRestHandle.USER_ROLE_AUTHENTICATION_PATH)
public interface UserRoleAuthenticationInterface {
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserOperationResponseDto findByUsernameAndPassword(
			@Valid final UserOperationRequestDto userOperationRequestDto);

	@GET
	@Path("/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoleRequestDto> findByToken(
			@PathParam("token") final String token);

}