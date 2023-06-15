package com.rcprdn.shopbackend.controller;

import com.rcprdn.shopbackend.entity.Cart;
import com.rcprdn.shopbackend.entity.Order;
import com.rcprdn.shopbackend.entity.User;
import com.rcprdn.shopbackend.repository.CartRepository;
import com.rcprdn.shopbackend.repository.OrderRepository;
import com.rcprdn.shopbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

  private final UserRepository userRepository;
  private final CartRepository cartRepository;
  private final OrderRepository orderRepository;

  // TODO implement get order by userId and orderId
//  @GetMapping("/{userId}/orders/{orderId}")
//  public Order getOrderById(@PathVariable Long userId, @PathVariable Long orderId) {
//    User user = userRepository.findById(userId)
//            .orElseThrow();
//
//    Order order =
//  }

  @PostMapping("/{userId}/cart/submit")
  public Order submitOrder(@PathVariable Long userId) {

    User user = userRepository.findById(userId)
            .orElseThrow();

    Cart cart;

    Order order = null;

    if (user.getCart() == null) {
      System.out.println("Kein Warenkorb vorhanden");
      // TODO add logic to handle empty order submission
    } else {
      cart = user.getCart();
      order = new Order();
      order.setUser(user);
      order.setCart(cart);

      order.setPaid(false);
      order.setDate(new Date());
      order.setShippingState(Order.ShippingState.PENDING);

      orderRepository.save(order);
      //user.getCart().clearCart();

    }
    return order;
  }
}
