package com.company.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private static final Logger _LOGGER = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
