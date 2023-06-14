package com.rcprdn.shopbackend.controller;

import com.rcprdn.shopbackend.entity.Product;
import com.rcprdn.shopbackend.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.rcprdn.shopbackend.dto.ProductCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;
  private final ModelMapper modelMapper;

  // POST

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
    return new ResponseEntity<>(this.productService.createProduct(modelMapper.map(productCreateDTO, Product.class)), HttpStatus.OK);
  }

  // GET

  @GetMapping
  public List<Product> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return products;
  }

  @GetMapping("/{id}")
  public Product getProductById(@Valid @PathVariable("id") Long id) {
    Product product = productService.getProductById(id);
    return product;
  }

  @GetMapping("/category/{category}")
  public List<Product> getProductsByCategory(@Valid @PathVariable("category") Product.Category category) {
    List<Product> products = productService.getProductsByCategory(category);
    return products;
  }

  @GetMapping("/availability/{availability}")
  public List<Product> getProductsByAvailability(@Valid @PathVariable("availability") Product.Availability availability) {
    List<Product> products = productService.getProductsByAvailability(availability);
    return products;
  }

  // DELETE

  @DeleteMapping("/{id}")
  public void deleteProduct(@Valid @PathVariable("id") Long id) {
    productService.deleteProduct(id);
  }
}
