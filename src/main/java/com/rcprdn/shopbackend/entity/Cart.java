package com.rcprdn.shopbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  @JsonIgnore
  public Map<Product, Integer> getItems() {
    return items;
  }

  @JsonProperty("items")
  public List<ProductCount> getItemsList() {
    return items.entrySet().stream()
            .map(entry -> new ProductCount(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
  }

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
