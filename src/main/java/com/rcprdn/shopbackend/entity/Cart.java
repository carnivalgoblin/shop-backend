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

  public void addProduct(Product product, int quantity) {
    if (items.containsKey(product)) {
      int exisitingQuantity = items.get(product);
      items.put(product, exisitingQuantity + quantity);
    } else {
      items.put(product, quantity);
    }
  }

  public void clearCart() {
    this.items.clear();
  }
}
