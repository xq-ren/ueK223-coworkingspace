package ch.zli.m223.model;

import javax.validation.constraints.NotBlank;

public class Credential {

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  public String getUsername() {
    return this.username;
    }

public void setUsername(String username) {
    this.username = username;
    }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}