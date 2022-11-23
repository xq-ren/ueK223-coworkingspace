package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Credential;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {

  @Inject
  AppUserService appUserService;
  @Inject
  JsonWebToken jwt;

  @Transactional
  public String loginUser(String username, String passwort) {
    List<AppUser> appUsers = appUserService.findAll();
    String jwt = "";
    for (AppUser appUser : appUsers) {
        if (appUser.getUsername().equals(username) && appUser.getPassword().equals(passwort)) {
            String token = Jwt.issuer("https://example.com/issuer")
                    .upn(appUser.getUsername())
                    .groups(appUser.getRole().getRoleName())
                    .expiresIn(Integer.MAX_VALUE)
                    .sign();
            return jwt = token;
        }
    }
    throw new IllegalArgumentException("Passwort oder E-Mail stimmt nicht");
}
}
