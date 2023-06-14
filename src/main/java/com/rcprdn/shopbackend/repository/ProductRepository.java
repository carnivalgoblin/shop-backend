package com.rcprdn.shopbackend.repository;

import com.rcprdn.shopbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByCategory(Product.Category category);

  List<Product> findByAvailability(Product.Availability availability);

}
