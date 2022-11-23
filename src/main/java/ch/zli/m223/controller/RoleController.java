package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Role;
import ch.zli.m223.service.RoleService;

@Path("/roles")
public class RoleController {

    @Inject
    RoleService roleService;

  
    @GET
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get list of all roles", description = "will get a list with all roles")
    public List<Role> ListofRoles() {
        return roleService.findAll();
    }
    
}
