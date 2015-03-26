package vezzoni.api.controller.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import vezzoni.api.controller.PingController;

@Path(value = "/ping")
@Consumes(value = {MediaType.WILDCARD})
@Produces(value = {MediaType.APPLICATION_JSON})
public class PingControllerImpl implements PingController {

    @GET
    @Path(value = "/")
    @Produces(value = {MediaType.TEXT_HTML})
    @Override
    public Response ping() {
        return Response
                .status(Response.Status.OK)
                .entity("PONG")
                .build();
    }
    
}
