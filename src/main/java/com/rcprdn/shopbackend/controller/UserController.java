package com.rcprdn.shopbackend.controller;

import com.rcprdn.shopbackend.entity.Cart;
import com.rcprdn.shopbackend.entity.Product;
import com.rcprdn.shopbackend.entity.User;
import com.rcprdn.shopbackend.repository.CartRepository;
import com.rcprdn.shopbackend.repository.ProductRepository;
import com.rcprdn.shopbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;

  // USER OPERATIONS

  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id) {
    User user = userRepository.findById(id)
            .orElseThrow();

    return user;
  }

  // CART OPERATIONS

  @PostMapping("/{userId}/cart/products/{productId}")
  public Cart addProductToCart(@PathVariable Long userId, @PathVariable Long productId, @RequestParam("quantity") int quantity) {
    User user = (User) userRepository.findById(userId)
            .orElseThrow();

    Cart cart = user.getCart();

    if (cart == null) {
      cart = new Cart();
      user.setCart(cart);
    }

    Product product = productRepository.findById(productId)
            .orElseThrow();

    cart.addProduct(product, quantity);

    Cart updatedCart = cartRepository.save(cart);
    return updatedCart;
  }

  @GetMapping("/{userId}/cart")
  public Cart getCart(@PathVariable Long userId) {
    User user = (User) userRepository.findById(userId)
            .orElseThrow();

    Cart cart = user.getCart();

    return cart;
  }

  @DeleteMapping("/{userId}/cart/delete")
  public void deleteCart(@PathVariable Long userId) {
    User user = userRepository.findById(userId)
            .orElseThrow();

    Cart cart = user.getCart();
    cart.clearCart();

    cartRepository.save(cart);
  }

  @DeleteMapping("/{userId}/cart/{productId}/delete")
  public void deleteFromCart(@PathVariable Long userId, @PathVariable Long productId) {
    User user = userRepository.findById(userId)
            .orElseThrow();

    Cart cart = user.getCart();
    Map<Product, Integer> products = cart.getItems();
    Optional<Product> optionalProduct = productRepository.findById(productId);

    Product productToRemove = optionalProduct.get();

    products.remove(productToRemove);

    cartRepository.save(cart);

    // TODO add response for non existatnt cart product
  }

}
