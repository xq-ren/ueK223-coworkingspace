package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.service.AuthService;

@Path("/session")
@Tag(name = "Session", description = "Handling of sessions")
@RolesAllowed({ "User", "Admin" })
public class AuthController {
  
  @Inject
  AuthService authService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(summary = "Authenticate a user.", description = "Returns a token upon successful authentication.")
  public String authenticate(@QueryParam("username")String username, @QueryParam("passwort") String passwort) {
    return authService.loginUser(username, passwort);
  }
}