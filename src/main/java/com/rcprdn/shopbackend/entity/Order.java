package com.rcprdn.shopbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // ATTRIBUTES

  @ManyToOne
  private User user;

  @ManyToOne
  private Cart cart;

  @OneToOne
  private PaymentMethod paymentMethod;

  private Boolean paid;

  private ShippingState shippingState;

  private Date date;

  // ENUMS

  public enum ShippingState {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED
  }
}
