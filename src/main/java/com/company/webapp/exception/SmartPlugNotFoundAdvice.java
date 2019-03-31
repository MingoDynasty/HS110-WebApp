package com.company.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SmartPlugNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(SmartPlugNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(SmartPlugNotFoundException ex) {
    return ex.getMessage();
  }
}
