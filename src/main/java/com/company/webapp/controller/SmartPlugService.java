package com.company.webapp.controller;

import java.util.List;
import java.util.Optional;

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

  public Optional<SmartPlug> findOne(long id) {
    return this.smartPlugRepository.findById(id);
  }

  public SmartPlug insertSmartPlug(SmartPlug sp) {
    return this.smartPlugRepository.save(sp);
  }

  public void updateSmartPlug(SmartPlug sp) {
    // TODO
  }

  public void deleteSmartPlug(SmartPlug sp) {
    // TODO
  }
}
