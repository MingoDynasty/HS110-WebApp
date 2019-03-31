package com.company.webapp.exception;

public class SmartPlugNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public SmartPlugNotFoundException(Long id) {
    super("Could not find smart plug " + id);
  }
}
