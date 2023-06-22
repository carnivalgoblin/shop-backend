package com.rcprdn.shopbackend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

  private String email;
  private String password;

}
