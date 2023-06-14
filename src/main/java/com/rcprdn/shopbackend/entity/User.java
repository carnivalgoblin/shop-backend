package com.rcprdn.shopbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // ATTRIBUTES

  private String firstName;

  private String surName;

  private String password;

  private String email;

  @OneToOne
  private Cart cart;

  @OneToOne
  private Address address;

  @OneToMany
  private List<PaymentMethod> paymentMethods;
}
