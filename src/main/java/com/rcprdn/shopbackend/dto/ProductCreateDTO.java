package com.rcprdn.shopbackend.dto;

import com.rcprdn.shopbackend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDTO {

  private String name;

  private Float price;

  private String description;

  private Product.Category category;

  private Product.Availability availability;
}
