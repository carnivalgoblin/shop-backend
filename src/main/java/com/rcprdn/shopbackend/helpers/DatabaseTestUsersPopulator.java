package com.rcprdn.shopbackend.helpers;

import com.rcprdn.shopbackend.entity.Cart;
import com.rcprdn.shopbackend.entity.User;
import com.rcprdn.shopbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTestUsersPopulator implements CommandLineRunner {

  private UserRepository userRepository;

  @Autowired
  public DatabaseTestUsersPopulator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    User testUser = new User();
    testUser.setFirstName("Rico");
    testUser.setSurName("Prodan");
    testUser.setPassword("testpasswort");
    testUser.setEmail("e@mail.com");
    // testUser.setCart(new Cart());

    userRepository.save(testUser);

  }

}
