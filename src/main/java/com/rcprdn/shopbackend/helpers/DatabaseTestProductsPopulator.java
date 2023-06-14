package com.rcprdn.shopbackend.helpers;

import com.rcprdn.shopbackend.entity.Product;
import com.rcprdn.shopbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTestProductsPopulator implements CommandLineRunner {

  private ProductRepository productRepository;

  @Autowired
  public DatabaseTestProductsPopulator(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    // ELECTRONICS

    Product productOne = new Product();
    productOne.setName("Google Pixel 7 Pro");
    productOne.setPrice(899F);
    productOne.setAvailability(Product.Availability.AVAILABLE);
    productOne.setDescription("Das bisher leistungsstärkste Google Pixel.");
    productOne.setCategory(Product.Category.ELECTRONICS);

    Product productTwo = new Product();
    productTwo.setName("Google Pixel 7a");
    productTwo.setPrice(509F);
    productTwo.setAvailability(Product.Availability.AVAILABLE);
    productTwo.setDescription("Superschnell und sicher – mit nützlichen Funktionen für jeden Tag.");
    productTwo.setCategory(Product.Category.ELECTRONICS);

    Product productThree = new Product();
    productThree.setName("Google Pixel Fold");
    productThree.setPrice(1899F);
    productThree.setAvailability(Product.Availability.PREORDER);
    productThree.setDescription("Das erste faltbare Smartphone von Google – genial in jeder Hinsicht.");
    productThree.setCategory(Product.Category.ELECTRONICS);

    Product productFour = new Product();
    productFour.setName("Google Pixel Watch");
    productFour.setPrice(379F);
    productFour.setAvailability(Product.Availability.AVAILABLE);
    productFour.setDescription("Hier kommt die erste Smartwatch, die das Beste von Google und Fitbit vereint.");
    productFour.setCategory(Product.Category.ELECTRONICS);

    Product productFive = new Product();
    productFive.setName("Google Pixel Tablet");
    productFive.setPrice(679F);
    productFive.setAvailability(Product.Availability.PREORDER);
    productFive.setDescription("Das Tablet mit dem Besten von Google.");
    productFive.setCategory(Product.Category.ELECTRONICS);

    Product productSix = new Product();
    productSix.setName("Google Pixel Buds Pro");
    productSix.setPrice(219F);
    productSix.setAvailability(Product.Availability.AVAILABLE);
    productSix.setDescription("Hochwertiger und voller Klang, ganz nach deinen Bedürfnissen.");
    productSix.setCategory(Product.Category.ELECTRONICS);

    // CLOTHING

    Product productSeven = new Product();
    productSeven.setName("Jeans");
    productSeven.setPrice(79.99F);
    productSeven.setAvailability(Product.Availability.AVAILABLE);
    productSeven.setDescription("Klassische Jeans mit zeitlosem Stil und bequemer Passform.");
    productSeven.setCategory(Product.Category.CLOTHING);

    Product productEight = new Product();
    productEight.setName("T-Shirt");
    productEight.setPrice(19F);
    productEight.setAvailability(Product.Availability.LIMITED_STOCK);
    productEight.setDescription("Weiches T-Shirt mit modernem Schnitt für lässigen Komfort.");
    productEight.setCategory(Product.Category.CLOTHING);

    Product productNine = new Product();
    productNine.setName("Socken");
    productNine.setPrice(9F);
    productNine.setAvailability(Product.Availability.DISCONTINUED);
    productNine.setDescription("Bequeme Socken mit atmungsaktivem Material für ganztägigen Tragekomfort.");
    productNine.setCategory(Product.Category.CLOTHING);

    // BOOKS

    Product productTen = new Product();
    productTen.setName("Die Schattenchroniken: Verborgene Welten");
    productTen.setPrice(19.99F);
    productTen.setAvailability(Product.Availability.AVAILABLE);
    productTen.setDescription("Ein packender Fantasy-Roman über eine geheime Parallelwelt voller Magie.");
    productTen.setCategory(Product.Category.BOOKS);

    Product productEleven = new Product();
    productEleven.setName("Das letzte Rätsel: Das Vermächtnis des verschollenen Schatzes");
    productEleven.setPrice(19.99F);
    productEleven.setAvailability(Product.Availability.LIMITED_STOCK);
    productEleven.setDescription("Ein Abenteuerthriller, bei dem ein verschollener Schatz gelüftet wird.");
    productEleven.setCategory(Product.Category.BOOKS);

    Product productTwelve = new Product();
    productTwelve.setName("Die Zeitreisenden: Das Geheimnis der verlorenen Dimension");
    productTwelve.setPrice(19.99F);
    productTwelve.setAvailability(Product.Availability.OUT_OF_STOCK);
    productTwelve.setDescription("Ein Science-Fiction-Roman über eine Gruppe von Zeitreisenden auf einer gefährlichen Mission.");
    productTwelve.setCategory(Product.Category.BOOKS);

    // SAVE TO DATABASE

    productRepository.save(productOne);
    productRepository.save(productTwo);
    productRepository.save(productThree);
    productRepository.save(productFour);
    productRepository.save(productFive);
    productRepository.save(productSix);
    productRepository.save(productSeven);
    productRepository.save(productEight);
    productRepository.save(productNine);
    productRepository.save(productTen);
    productRepository.save(productEleven);
    productRepository.save(productTwelve);

  }

}
