package com.rcprdn.shopbackend.service;

import com.rcprdn.shopbackend.entity.Product;
import com.rcprdn.shopbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

  private final ProductRepository productRepository;

  // CREATE/UPDATE

  public Product createProduct (Product product) {
    return productRepository.save(product);
  }

  // READ

  public List<Product> getAllProducts() {
    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  public Product getProductById(Long id) { return productRepository.findById(id).orElseThrow(); }

  public List<Product> getProductsByCategory(Product.Category category) { return productRepository.findByCategory(category); }

  public List<Product> getProductsByAvailability(Product.Availability availability) { return productRepository.findByAvailability(availability); }

  // DELETE

  public void deleteProduct(Long id) { productRepository.deleteById(id); }
}
