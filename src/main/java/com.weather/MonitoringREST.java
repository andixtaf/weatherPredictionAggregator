package com.weather;

import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/api/v1/monitoring")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MonitoringREST
{
	private static Logger logger = Logger.getLogger(MonitoringREST.class);

	@GET
	@Path("/")
	public Response getSingle()
	{
		logger.info("monitoring required");
		return Response.ok("Everything ok").build();
	}
}
