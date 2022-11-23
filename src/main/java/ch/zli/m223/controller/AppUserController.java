package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.service.AppUserService;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
@RolesAllowed({ "User", "Admin" })
public class AppUserController {
    
    @Inject
    AppUserService appUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Index all Users.", description = "Returns a list of all users.")
    public List<AppUser> index() {
        return appUserService.findAll();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates new user", description = "Creates new user and returns it.")
    public AppUser createUser(AppUser user) {
       return appUserService.createUser(user);
    }

    @Path("/{id}")
    @DELETE
    @Operation( summary = "Deletes an user.", description = "Deletes user with certain id.")
    public void delete(@PathParam("id") Long id) {
      appUserService.deleteUser(id);
  }

    @Path("/{id}")
    @PUT
    @Operation(summary = "Updates an user.", description = "update user with certain id.")
    public AppUser update(@PathParam("id") Long id, AppUser user) {
        return appUserService.updateUser(id, user);
  }


}
