package com.rcprdn.shopbackend.controller;

import com.rcprdn.shopbackend.entity.Cart;
import com.rcprdn.shopbackend.entity.Product;
import com.rcprdn.shopbackend.repository.CartRepository;
import com.rcprdn.shopbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

  private final ProductRepository productRepository;
  private final CartRepository cartRepository;

  @PostMapping("/{cartId}/products/{productId}") // EXAMPLE: /carts/{cartId}/products/{productId}?quantity=2
  public Cart addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam("quantity") int quantity) {
    Cart cart = cartRepository.findById(cartId)
            .orElseGet(() -> {
              Cart newCart = new Cart();
              return cartRepository.save(newCart);
            });

    Product product = productRepository.findById(productId)
            .orElseThrow();

    cart.addProduct(product, quantity);

    Cart updatedCart = cartRepository.save(cart);
    return updatedCart;
  }

  // GET

  @GetMapping("/{cartId}")
  public Cart getCartById(@PathVariable Long cartId) {
    Cart cart = cartRepository.findById(cartId)
            .orElseThrow();
    return cart;
  }
}
