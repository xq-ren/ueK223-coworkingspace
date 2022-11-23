package ch.zli.m223.service;


import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.eclipse.microprofile.jwt.JsonWebToken;
import ch.zli.m223.model.AppUser;
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
