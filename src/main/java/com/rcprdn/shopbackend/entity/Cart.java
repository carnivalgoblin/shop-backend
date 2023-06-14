package com.rcprdn.shopbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // ATTRIBUTES

  @ElementCollection
  @Column(name = "quantity")
  private Map<Product, Integer> items = new HashMap<>();

  // METHODS

  public void addProduct(Product product) {
    if (items.containsKey(product)) {
      int quantity = items.get(product);
      items.put(product, quantity + 1);
    } else {
      items.put(product, 1);
    }
  }
}
