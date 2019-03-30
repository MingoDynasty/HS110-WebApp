package com.wong.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MingoController {
  private static final Logger _LOGGER = LoggerFactory.getLogger(MingoController.class);

  @Autowired private StudentRepository studentRepository;

  private static int counter = 0;

  @PostMapping("mypost")
  public void test(@RequestParam("sha") String sha, @RequestParam("msg") String msg) {
    _LOGGER.info("Hit mypost");
    _LOGGER.info("sha : {}", sha);
    _LOGGER.info("msg : {}", msg);
  }

  @RequestMapping("/mingo")
  public String index() {
    _LOGGER.info("Reached: /mingo");
    List<Student> students = this.studentRepository.findAll();
    for (Student student : students) {
      _LOGGER.info("Name: {}", student.getName());
    }

    String response = String.format("You have hit this endpoint %d times!", ++counter);
    _LOGGER.info("/mingo responded with: {}", response);
    return response;
  }

  @RequestMapping("/myget")
  public ResponseEntity<String> get() {
    _LOGGER.info("Reached: /myget");
    ResponseEntity<String> response =
        ResponseEntity.ok().header("Custom-Header", "foo").body("Custom header set");
    _LOGGER.info("/myget responded with: {}", response);
    return response;
  }
}
