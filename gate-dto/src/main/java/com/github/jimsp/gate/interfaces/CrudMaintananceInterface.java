package com.github.jimsp.gate.interfaces;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface CrudMaintananceInterface<Request, Response> {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@Valid final Request request);

	@DELETE
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response remove(@Valid final Request request);

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> findAll();

	@GET
	@Path("/{name}/exist")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean existName(@PathParam("name") final String name);

}
