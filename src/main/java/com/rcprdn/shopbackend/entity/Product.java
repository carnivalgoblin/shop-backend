package com.rcprdn.shopbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // ATTRIBUTES

  private String name;

  private Float price;

  private String description;

  private Category category;

  private Availability availability;

  // ENUMS

  public enum Category {
    ELECTRONICS,
    CLOTHING,
    BOOKS
  }

  public enum Availability {
    AVAILABLE,
    OUT_OF_STOCK,
    LIMITED_STOCK,
    DISCONTINUED,
    PREORDER
  }
}
