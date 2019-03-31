package com.company.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.webapp.model.Student;
import com.company.webapp.repository.StudentRepository;

@RestController
public class MingoController {
  private static final Logger logger = LoggerFactory.getLogger(MingoController.class);

  @Autowired private StudentRepository studentRepository;

  private static int counter = 0;

  @PostMapping("mypost")
  public void test(@RequestParam("sha") String sha, @RequestParam("msg") String msg) {
    logger.info("Hit mypost");
    logger.info("sha : {}", sha);
    logger.info("msg : {}", msg);
  }

  @GetMapping("/mingo")
  public String index() {
    logger.info("Reached: /mingo");
    List<Student> students = this.studentRepository.findAll();
    for (Student student : students) {
      logger.info("Name: {}", student.getName());
    }

    String response = String.format("You have hit this endpoint %d times!", ++counter);
    logger.info("/mingo responded with: {}", response);
    return response;
  }

  @GetMapping("/myget")
  public ResponseEntity<String> get() {
    logger.info("Reached: /myget");
    ResponseEntity<String> response =
        ResponseEntity.ok().header("Custom-Header", "foo").body("Custom header set");
    logger.info("/myget responded with: {}", response);
    return response;
  }
}
