package com.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.store")
@EnableWebMvc
public class StoreManagementApplication {

  /**
   * Main class starting app
   *
   * @param args No arguments required
   */
  public static void main(String[] args) {
    SpringApplication.run(StoreManagementApplication.class, args);
  }
}
