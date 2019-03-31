package com.company.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.webapp.model.SmartPlug;
import com.company.webapp.repository.SmartPlugRepository;

@Service
public class SmartPlugService {
  private static final Logger logger = LoggerFactory.getLogger(SmartPlugService.class);

  @Autowired SmartPlugRepository smartPlugRepository;

  public List<SmartPlug> findAll() {
    return this.smartPlugRepository.findAll();
  }

  public void insertSmartPlug(SmartPlug sp) {
    // TODO
  }

  public void updateSmartPlug(SmartPlug sp) {
    // TODO
  }

  public void deleteSmartPlug(SmartPlug sp) {
    // TODO
  }
}
