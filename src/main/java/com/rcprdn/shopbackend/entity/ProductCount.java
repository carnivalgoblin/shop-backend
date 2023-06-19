package com.rcprdn.shopbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class ProductCount {
  
  @OneToOne
  private Product product;

  private Integer count;

}
