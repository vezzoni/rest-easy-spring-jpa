package vezzoni.api.controller.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vezzoni.api.controller.ApiController;
import vezzoni.api.service.ApiService;

@Controller
@Path(value = "/")
@Consumes(value = {MediaType.WILDCARD})
@Produces(value = {MediaType.APPLICATION_JSON})
public class ApiControllerImpl implements ApiController {

    @Autowired
    private ApiService service;
    
    @GET
    @Path(value = "/{name}")
    @Produces(value = {MediaType.TEXT_HTML})
    @Override
    public Response greetings(@PathParam("name") String name) {
        
        String message = service.greetings(name);
        
        return Response
                .status(Response.Status.OK)
                .entity(message)
                .build();
    }

    @PUT
    @Path(value = "/{id}")
    @Override
    public Response insert(@PathParam("id") Integer id) {
        
        service.insert(id);
        
        return Response
                .status(Response.Status.CREATED)
                .build();
    }

}
